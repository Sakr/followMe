package fr.esiea.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.set.CompositeSet.SetMutator;
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

import fr.esiea.web.bean.NotificationsFormBean;
import fr.esiea.web.model.ActivityDetail;
import fr.esiea.web.model.ActivityParticipants;
import fr.esiea.web.model.User;
import fr.esiea.web.service.ActivityDetailService;
import fr.esiea.web.service.ActivityNameService;
import fr.esiea.web.service.ActivityParticipantsService;
/**
 * @author sakr
 *
 */
@Controller
@SessionAttributes({"error","connectedUser","activityDetailList","notificationsFormBeanList","imageNotification","notification"})
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
    
    public void getDataForUser(ModelMap model){
    	
    	//On ajoute les données de l'utilisateur
    	User connectedUser=this.getCurrentUserSession();
    	model.put("connectedUser", connectedUser);
    	
    	//On recupere la liste des activites a afficher 
    	List<ActivityDetail>allActivityDetailList= activityDetailService.listActivityDetail();
    	model.put("activityDetailList", allActivityDetailList);
    	
    	//On recupere les activites de l'utilisateur pour voir si il a recu des demandes de participations a ses activité
    	List<ActivityDetail>userActivityDetailList=new ArrayList<ActivityDetail>();
    	for(ActivityDetail activityDetail:allActivityDetailList){
    		if(activityDetail.getCreator().getId()==connectedUser.getId()){
    			//On recupere la liste des activites
    			userActivityDetailList.add(activityDetail);
    		}
    	}
    	//Si l'utilisateur a deja crée des activites 
    	NotificationsFormBean notificationsFormBean=null;
    	List<NotificationsFormBean>notificationsFormBeanList=new ArrayList<NotificationsFormBean>();
    	if(userActivityDetailList.size()!=0){
    		//On verifie si il a des participants a ses activites
    		List<ActivityParticipants> listActivityParticipants=activityParticipantsService.listActivityParticipants();
    		for(ActivityDetail activityDetail: userActivityDetailList){
    			for(ActivityParticipants activityParticipants: listActivityParticipants){
    				if(activityDetail.getId()==activityParticipants.getActivityDetail().getId()){
    					//On verfie si l'utilisateur n'est pas deja accepté
    					if(!activityParticipants.getAccepted()){
    						notificationsFormBean=new NotificationsFormBean();
        					notificationsFormBean.setIdActivityParticipant(activityParticipants.getId());
        					notificationsFormBean.setIdUser(activityParticipants.getParticipant().getId());
        					notificationsFormBean.setMail(activityParticipants.getParticipant().getMail());
        					notificationsFormBean.setLabelNotification(activityNameService.getActivityNameById(activityDetail.getId()).getName()+" - "+activityDetail.getDateCreation()+":  "+activityParticipants.getParticipant().getName()+" "+activityParticipants.getParticipant().getFirstName());
        					notificationsFormBeanList.add(notificationsFormBean);
    					}
    				}
    			}
    		}
    	}
    	model.put("notificationsFormBeanList", notificationsFormBeanList);
    	String extention=".png";
    	String path="resources/images/notifications/notification-0"+notificationsFormBeanList.size()+extention;
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
    	
    	this.sendEmail(notificationsFormBeanList.get(index).getLabelNotification(), messages.getString("participant.accepted.text"), notificationsFormBeanList.get(index).getMail());
    	
    	ModelAndView  mav = new ModelAndView("user");
		getDataForUser(model);
    	return mav;
	}
}
