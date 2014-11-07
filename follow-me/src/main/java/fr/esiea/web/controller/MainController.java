package fr.esiea.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.web.bean.ActivityFormBean;
import fr.esiea.web.bean.NotificationsFormBean;
import fr.esiea.web.model.ActivityDetail;
import fr.esiea.web.model.ActivityName;
import fr.esiea.web.model.ActivityParticipants;
import fr.esiea.web.model.Adress;
import fr.esiea.web.model.User;
import fr.esiea.web.service.ActivityDetailService;
import fr.esiea.web.service.ActivityNameService;
import fr.esiea.web.service.ActivityParticipantsService;
import fr.esiea.web.service.LongitudeLatitudeService;
import fr.esiea.web.service.UserService;
/**
 * @author sakr
 *
 */
@Controller
@SessionAttributes({"error","connectedUser","activityDetailList","notificationsFormBeanList","imageNotification","notification","activityFormBean"})
public class MainController extends ConfigController{
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getCommonPage(@RequestParam(value="error", required=false) boolean error,
    		ModelMap model) {
    	logger.debug("Launch user page");
    	User connectedUser=null;
    	if(this.getCurrentUserSession()==null){
    		error=true;
    	}else{
    		connectedUser=this.getCurrentUserSession();
    	}
    	
        ModelAndView mav;
        if(error){
        	model.put("error",messages.getString( "login.failed.userOrPassword"));
        	mav = new ModelAndView("login");
        }else{
        	if(connectedUser.getDisabled()){
        		model.put("error",messages.getString( "login.failed.disabled"));
            	mav = new ModelAndView("login");
        	}else{
        		mav = new ModelAndView("user");
        		getDataForUser(model);
        	}
        }
        
		
    	return mav;
	}
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getAdminPage() {
    	
    	logger.debug("Launch admin page");
		ModelAndView mav = new ModelAndView("admin");
    	return mav;
	}
    
    
    @Autowired
	private ActivityDetailService activityDetailService;
    @Autowired
	private ActivityParticipantsService activityParticipantsService;
    @Autowired
    private ActivityNameService activityNameService;
    @Autowired
    private UserService userService;
    
    
    public void getDataForUser(ModelMap model){
    	
    	//On ajoute les données de l'utilisateur
    	User connectedUser=this.getCurrentUserSession();
    	model.put("connectedUser", connectedUser);
    	
    	//On recupere la liste des activites a afficher 
    	List<ActivityDetail>allActivityDetailList=new ArrayList<ActivityDetail>();
    	allActivityDetailList=activityDetailService.listActivityDetail();
    	model.put("activityDetailList", allActivityDetailList);
    	
    	//On recupere les activites de l'utilisateur pour voir si il a recu des demandes de participations a ses activité
    	List<ActivityDetail>userActivityDetailList=new ArrayList<ActivityDetail>();
    	for(ActivityDetail activityDetail:allActivityDetailList){
    		userActivityDetailList.add(activityDetail);
    	}
    	//Si l'utilisateur a deja crée des activites 
    	NotificationsFormBean notificationsFormBean=new NotificationsFormBean();
    	List<NotificationsFormBean>notificationsFormBeanList=new ArrayList<NotificationsFormBean>();
		List<ActivityParticipants> listActivityParticipants=activityParticipantsService.listActivityParticipants();
			for(ActivityParticipants activityParticipants: listActivityParticipants){
				//On verfie si l'utilisateur n'est pas deja accepté
				if(!activityParticipants.getAccepted()){
					notificationsFormBean=new NotificationsFormBean();
					notificationsFormBean.setIdActivityParticipant(activityParticipants.getId());
					notificationsFormBean.setIdUser(activityParticipants.getParticipant().getId());
					notificationsFormBean.setMail(activityParticipants.getParticipant().getMail());
					notificationsFormBean.setLabelNotification(activityNameService.getActivityNameById(2).getName()+" :  "+activityParticipants.getParticipant().getName()+" "+activityParticipants.getParticipant().getFirstName());
					notificationsFormBeanList.add(notificationsFormBean);
				}
			}
    	
    	model.put("notificationsFormBeanList", notificationsFormBeanList);
    	
    	//On ajoute l'image de notification
    	//TODO a gerer avec la base de donnée
    	String extention=".png";
    	String path="";
    	if(notificationsFormBeanList.size()!=0){
    		path="resources/images/notifications/notification-0"+notificationsFormBeanList.size()+extention;
    	}
    	model.put("imageNotification", path);
    }
    
    
    @RequestMapping(value = "/accept", method = RequestMethod.GET)
    public ModelAndView acceptParticipant(ModelMap model,@ModelAttribute("notificationsFormBeanList")List<NotificationsFormBean> notificationsFormBeanList,
			@RequestParam(value = "index", required = true) int index) {
    	
    	ActivityParticipants activityParticipants= activityParticipantsService.getActivityParticipantsById(notificationsFormBeanList.get(index).getIdActivityParticipant());
        
    	//On accepte l'utilisateur
    	activityParticipants.setAccepted(true);
    	
    	//On enregistre sur la base de donnée
    	activityParticipantsService.updateActivityParticipants(activityParticipants);
    	
    	//On envoi un mail a l'utilisateur accépté
    	this.sendEmail(notificationsFormBeanList.get(index).getLabelNotification(), messages.getString("participant.accepted.text"), notificationsFormBeanList.get(index).getMail());
    	
    	ModelAndView  mav = new ModelAndView("user");
    	
    	return mav;
	}
    
    @RequestMapping(value = "/addActivity", method = RequestMethod.GET)
    public ModelAndView addActivity(ModelMap model) {
    	
    	ActivityFormBean activityFormBean=new ActivityFormBean();
    	ModelAndView  mav = new ModelAndView("addActivityView");
    	
    	List<ActivityName> liActivityNames= activityNameService.listActivityName();
    	activityFormBean.setListNameActivity(liActivityNames);
    	model.put("activityFormBean", activityFormBean);	
    	return mav;
	}
    
    @RequestMapping(value = "/saveAddActivity")
    public ModelAndView saveAddActivity(ModelMap model,
    		@ModelAttribute("activityFormBean")ActivityFormBean activityFormBean) {
    	
    	//On recupere le createur de l'activite
    	User connectedUser=this.getCurrentUserSession();
    	//On recupere les donnees de l'adresse a partir du formulaire
	    Adress adress=new Adress();
	    adress.setNumber(new Integer(activityFormBean.getNumber()));
	    adress.setStreet(activityFormBean.getStreet());
	    adress.setPostcode(new Integer(activityFormBean.getPostcode()));
	    adress.setCity(activityFormBean.getCity());
	    adress.setEstablishment("");
	    
	    //On recupere la longitude et la latitude en fonction de l'adresse de l'utilisateur
	    LongitudeLatitudeService directionService = new LongitudeLatitudeService();
        Map<String,Double> logLatMap= directionService.getLongitudeLatitude(adress);
	    
	    adress.setLatitude(logLatMap.get("latitude"));
	    adress.setLongitude(logLatMap.get("longitude"));
	    
	    //On recupere le detail de l'activite
	    ActivityDetail activityDetail=new ActivityDetail();
	    //activityDetail.get
	    activityDetail.setAdress(adress);
	    ActivityName activityName=new ActivityName();
	    activityName.setId(new Integer(activityFormBean.getActivityNameId()));
	    activityDetail.setNameActivity(activityName);
	    activityDetail.setDescription(activityFormBean.getDescription());
	    activityDetail.setDifficulty(new Integer(activityFormBean.getDifficulty()));
	    activityDetail.setDuration(new Integer(activityFormBean.getDuration()));
	    activityDetail.setEffectiveDate(activityFormBean.getEffectiveDate());
	    activityDetail.setParticipantsNumber(new Integer(activityFormBean.getParticipantsNumber()));
	    activityDetail.setAvailablePlaces(new Integer(activityFormBean.getParticipantsNumber()));
	    activityDetail.setDateCreation(new Date());
	    //On enregistre l'activité sur la base de donnée
	    activityDetailService.createActivityDetail(activityDetail);
	    
	    
	    userService.updateUser(connectedUser);
	    
    	ModelAndView  mav = new ModelAndView("user");
    	return mav;
	}
    
    @RequestMapping(value = "/resetAddActivity", method = RequestMethod.GET)
    public ModelAndView resetAddActivity(ModelMap model) {
    	//TODO Reset
    	ModelAndView  mav = new ModelAndView("user");
    	return mav;
	}
    
}
