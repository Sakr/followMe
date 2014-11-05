/*******************************************************************************
 * Variables
 ******************************************************************************/

var changeData;

// tableau datatable
var oTable;
// liste des objets oTable qui represente chacun une table
// dans le formulaire qui est affiche.
var oTableList = new Array();
// options �ventuelles du tableau d�finies dans la page
var otableOptionsList = new Array();


/*******************************************************************************
 * Fonctions
 ******************************************************************************/
function changeLanguage(language) {
	if (language.value=='fr') { // require a URL
	    window.location.href = "?locale=fr"; // redirect
	}else{
		  window.location.href = "?locale=en";
	}
}
function closePopup(){
	parent.$.fancybox.close();
}

/**
 * cache et detruit un datatable
 */
function hideTable() {
	$('.dataTable').hide();
	$('.dataTables_length').hide();
	$('.dataTables_filter').hide();
	$('.dataTables_paginate').hide();
	$('.dataTables_info').hide();
	oTable.fnDestroy();
}

function doGet(url) {
	parent.$.fancybox.close();
	window.location.href = url;
}

/**
 * Gestion des accordeons
 */

// Gestion des accordeons en mode edition
function openAccordeon(accordeonIndex){
	$('.acc_trigger_' + accordeonIndex).addClass('active').next().show();
}
function openSousAccordeon(accordeonIndex){
	$('.acc_trigger_fils_' + accordeonIndex).addClass('active').next().show();
}

/**
 * Plugin datable permettant de changer a la volee le nombre d'element a
 * afficher
 */
$.fn.dataTableExt.oApi.fnLengthChange = function ( oSettings, iDisplay )
{
	if(oSettings) {
	    oSettings._iDisplayLength = iDisplay;
	    oSettings.oApi._fnCalculateEnd( oSettings );
	     
	    /*
		 * If we have space to show extra rows (backing up from the end point -
		 * then do so
		 */
	    if ( oSettings._iDisplayEnd == oSettings.aiDisplay.length )
	    {
	        oSettings._iDisplayStart = oSettings._iDisplayEnd - oSettings._iDisplayLength;
	        if ( oSettings._iDisplayStart < 0 )
	        {
	            oSettings._iDisplayStart = 0;
	        }
	    }
	     
	    if ( oSettings._iDisplayLength == -1 )
	    {
	        oSettings._iDisplayStart = 0;
	    }
	     
	    oSettings.oApi._fnDraw( oSettings );
	     
	   // $('select', oSettings.oFeatures.l).val( iDisplay );
	}
}

/**
 * On centre les checkbox dans les tableaux
 */
function centerCheckboxes() {
	$(".dataTable input[type=checkbox]").parent().css("text-align", "center");
}



/**
 * selectionne automatiquement le contenu d'un champ input text
 */
function inputFocus() {
	$("input[type='text']").on("click", function () {
		   $(this).select();
		});
}


// fomat une Date suivant un separateur .
// example : retourne une date au format DD/MM/YYY si separateur ='/'
function formatDate(date,separator) {
	  if(date == null) return null;
	  var curr_date = date.getDate();
	  // formatage sur 2 positions
	  if(curr_date.toString().length < 2) {
		  curr_date = 0 + curr_date.toString();
	  }
	  var curr_month = date.getMonth() + 1; 
	  // formatage sur 2 positions
	  if(curr_month.toString().length < 2) {
		  curr_month = 0 + curr_month.toString();
	  }
   var curr_year = date.getFullYear();     
   return (curr_date + separator + curr_month + separator + curr_year); 
}



/*
 * Natural Sort algorithm for Javascript - Version 0.6 - Released under MIT
 * license Author: Jim Palmer (based on chunking idea from Dave Koelle)
 * Contributors: Mike Grier (mgrier.com), Clint Priest, Kyle Adams, guillermo
 */
function naturalSort (a, b) {

  // Si a et b sont des numeric ,suppression
  // des caracteres de formatage utilises.
  // TODO : optimizer l'expression reguliere.
  var regExp = new RegExp("^([0-9]+)");
	if( regExp.test(a) ){
		a = replaceAll(a,' ', '');
	}
	if( regExp.test(b) ){
		b = replaceAll(b,' ', '');
	}
	var re = /(^-?[0-9]+(\.?[0-9]*)[df]?e?[0-9]?$|^0x[0-9a-f]+$|[0-9]+)/gi,
		sre = /(^[ ]*|[ ]*$)/g,
		dre = /(^([\w ]+,?[\w ]+)?[\w ]+,?[\w ]+\d+:\d+(:\d+)?[\w ]?|^\d{1,4}[\/\-]\d{1,4}[\/\-]\d{1,4}|^\w+, \w+ \d+, \d{4})/,
		hre = /^0x[0-9a-f]+$/i,
		ore = /^0/,
		// convert all to strings and trim()
		x = a.toString().replace(sre, '') || '',
		y = b.toString().replace(sre, '') || '',
		// chunk/tokenize
		xN = x.replace(re, '\0$1\0').replace(/\0$/,'').replace(/^\0/,'').split('\0'),
		yN = y.replace(re, '\0$1\0').replace(/\0$/,'').replace(/^\0/,'').split('\0'),
		// numeric, hex or date detection
		xD = parseInt(x.match(hre)) || (xN.length != 1 && x.match(dre) && Date.parse(x)),
		yD = parseInt(y.match(hre)) || xD && y.match(dre) && Date.parse(y) || null;
	// first try and sort Hex codes or Dates
	if (yD)
		if ( xD < yD ) return -1;
		else if ( xD > yD )	return 1;
	// natural sorting through split numeric strings and default strings
	for(var cLoc=0, numS=Math.max(xN.length, yN.length); cLoc < numS; cLoc++) {
		// find floats not starting with '0', string or 0 if not defined (Clint
		// Priest)
		oFxNcL = !(xN[cLoc] || '').match(ore) && parseFloat(xN[cLoc]) || xN[cLoc] || 0;
		oFyNcL = !(yN[cLoc] || '').match(ore) && parseFloat(yN[cLoc]) || yN[cLoc] || 0;
		// handle numeric vs string comparison - number < string - (Kyle Adams)
		if (isNaN(oFxNcL) !== isNaN(oFyNcL)) return (isNaN(oFxNcL)) ? 1 : -1; 
		// rely on string comparison if different types - i.e. '02' < 2 != '02'
		// < '2'
		else if (typeof oFxNcL !== typeof oFyNcL) {
			oFxNcL += ''; 
			oFyNcL += ''; 
		}
		if (oFxNcL < oFyNcL) return -1;
		if (oFxNcL > oFyNcL) return 1;
	}
	return 0;
}
	
jQuery.fn.dataTableExt.oSort['natural-asc']  = function(a,b) {
    return naturalSort(a,b);
};
	 
jQuery.fn.dataTableExt.oSort['natural-desc'] = function(a,b) {
    return naturalSort(a,b) * -1;
};

/* Create an array with the values of all the input boxes in a column */
// cette methode met a jour le contenu de cache de datatables jquery
// le tri sur les colonnes va prendre en compte les nouvelles donnees saisies
// dans
// les champs input qui se trouvent a l'interieur des colonnes de la table
$.fn.dataTableExt.afnSortData['dom-text'] = function  ( oSettings, iColumn )
{
	var aData = [];
	// L'option FixedColumn appliquee sur la table
	if( oSettings.aoColumns[0].bVisible == false ){
	  if( ( iColumn  - 1 ) < 0  ){
		 return aData;
	  }else{
 	 iColumn = iColumn - 1;
	}
}
	
	$( 'td:eq('+iColumn+') input[type="text"]', oSettings.oApi._fnGetTrNodes(oSettings) ).each( function () {
		aData.push( this.value );
	} );
	return aData;
}

$.fn.dataTableExt.afnSortData['text-fixedColumn'] = function  ( oSettings, iColumn )
{
	var aData = [];
	 // L'option FixedColumn appliquee sur la table
	 if( oSettings.aoColumns[0].bVisible == false ){
	  if( ( iColumn  - 1 ) < 0  ){
			 return aData;
	   }else{
			 iColumn = iColumn - 1;
	  }
}
	
	$( 'td:eq('+iColumn+')', oSettings.oApi._fnGetTrNodes(oSettings) ).each( function () {
		// Internet Explorer
		if ( $.browser.msie ) { 
				aData.push(this.innerText);
			// Mozilla FireFox
		    }else if($.browser.mozilla ){
				aData.push(this.textContent);
		}
		
	} );
	return aData;
}

/* Create an array with the values of all the select options in a column */
$.fn.dataTableExt.afnSortData['dom-select'] = function  ( oSettings, iColumn )
{
	var aData = [];
	
	// L'option FixedColumn appliquee sur la table
	 if( oSettings.aoColumns[0].bVisible == false ){
	  if( ( iColumn  - 1 ) < 0  ){
			 return aData;
	   }else{
			 iColumn = iColumn - 1;
	  }
}
	    
	$( 'td:eq('+iColumn+') select', oSettings.oApi._fnGetTrNodes(oSettings) ).each( function () {
		aData.push( $(this).val() );
	} );
	return aData;
}


/* Create an array with the values of all the checkboxes in a column */
$.fn.dataTableExt.afnSortData['dom-checkbox'] = function  ( oSettings, iColumn )
{
	var aData = [];
	 // L'option FixedColumn appliquee sur la table
	 if( oSettings.aoColumns[0].bVisible == false ){
	  if( ( iColumn  - 1 ) < 0  ){
			 return aData;
	   }else{
			 iColumn = iColumn - 1;
	  }
}
	    
	$( 'td:eq('+iColumn+') input', oSettings.oApi._fnGetTrNodes(oSettings) ).each( function () {
		aData.push( this.checked==true ? "1" : "0" );
	} );
	return aData;
}
/* gestion des erreurs de datatables */
$.fn.dataTableExt.sErrMode = 'throw';
	
$.fn.dataTableExt.oApi.fnMultiRowspan = function ( oSettings, oSpannedColumns, bCaseSensitive ) {
    /*
	 * Type: Plugin for DataTables (http://datatables.net) JQuery plugin. Name:
	 * dataTableExt.oApi.fnMultiRowspan Requires: DataTables 1.6.0+ Version: 0.7
	 * Description: Creates rowspan cells in one or more columns when there are
	 * two or more cells in a row with the same content.
	 * 
	 * Inputs: object:oSettings - dataTables settings object
	 * object:oSpannedColumns - the columns to fake rowspans in
	 * boolean:bCaseSensitive - whether the comparison is case-sensitive or not
	 * (default: false) Returns: JQuery Usage:
	 * $('#example').dataTable().fnMultiRowspan([0]);
	 * $('#example').dataTable().fnMultiRowspan({0: 0, 1: 0, 2: 0}, true);
	 * $('#example').dataTable().fnMultiRowspan({"engine.name": "engine.name",
	 * "grade": "grade"});
	 * 
	 * Author: Kaarel Nummert Comment: Based on the fnFakeRowspan
	 * (http://datatables.net/plug-ins/api#fnFakeRowspan) plug-in created by
	 * Fredrik Wendel. Created: 2011-09-02 Language: Javascript License: GPL v2
	 * or BSD 3 point style
	 */
    var oSettings = oSettings,
        oSpannedColumns = oSpannedColumns,
        bCaseSensitive = (typeof(bCaseSensitive) != 'boolean' ? false : bCaseSensitive);
  
    oSettings.aoDrawCallback.push({ "fn": fnMultiRowspan, "sName": "fnMultiRowspan" });
  
    function fnMultiRowspan () {
        /*
		 * Reset rowspans. Should probably check if any of those columns are
		 * meant to be hidden. There is that option in DataTables, you know.
		 */
        oSettings.oInstance.children("tbody").find("td").removeAttr("rowspan").show();
 
        // Need to move all numeric keys and values one to the left where >
		// hidden col index
        var oSpannedColumnsTemp = new Object();
        for (key in oSpannedColumns)
            oSpannedColumnsTemp[key] = oSpannedColumns[key];
        for (index in oSettings.aoColumns) {
            var indexInt = parseInt(index);
            if (typeof(indexInt) == 'number' && !oSettings.aoColumns[index].bVisible) {
                var oSpannedColumnsKeyTransitions = new Object(); // Map of
																	// previous
																	// key to
																	// new key
                for (key in oSpannedColumnsTemp) {
                    var newVal = oSpannedColumnsTemp[key];
                    var newValInt = parseInt(newVal);
                    if (typeof(newValInt) == 'number' && newValInt > indexInt)
                        oSpannedColumnsTemp[key] = '' + (newValInt-1);
                    var keyInt = parseInt(key);
                    if (typeof(keyInt) == 'number' && keyInt > indexInt)
                        oSpannedColumnsKeyTransitions[key] = '' + (keyInt-1);
                }
                for (key in oSpannedColumnsKeyTransitions) {
                    oSpannedColumnsTemp[oSpannedColumnsKeyTransitions[key]] = oSpannedColumnsTemp[key];
                    delete oSpannedColumnsTemp[key];
                }
            }
        }
 
        /* Reset values on new cell data. */
        var firstOccurance = {},
            value = {},
            rowspan = {};
  
        for (i = 0; i < oSettings.aiDisplay.length; i++) {
            oData = oSettings.aoData[oSettings.aiDisplay[i]];
            for (key in oSpannedColumnsTemp) {
                var index = fnCellIndexByKey(key);
                  
                if (oSpannedColumnsTemp[key] === null || index === null)
                    continue;
 
                var cell = $($(oData.nTr).children().get(index)),
                    comparisonKey = oSpannedColumnsTemp[key],
                    val = oSettings.oApi._fnGetObjectDataFn(comparisonKey).call(oData, oData._aData);
  
                /* Use lowercase comparison if not case-sensitive. */
                if (!bCaseSensitive)
                    val = val.toLowerCase();
 
                if (typeof value[key] == "undefined" || val != value[key]) {
                    value[key] = val;
                    firstOccurance[key] = cell;
                    rowspan[key] = 1;
                } else
                    rowspan[key]++;
 
                if (typeof firstOccurance[key] != "undefined" && val == value[key] && rowspan[key] > 1) {
                    cell.hide();
                    firstOccurance[key].attr("rowspan", rowspan[key]);
                }
            }
        }
    }
      
    function fnCellIndexByKey (key) {
        for (index in oSettings.aoColumns) {
            if (oSettings.aoColumns[index].mDataProp == key) {
                return index;
            }
        }
        return null;
    }
  
    /* Ensure rowspanning is done even if the table has already been drawn. */
    fnMultiRowspan();
  
    return this;
}

/**
 * submit du formulaire
 * 
 * @param url
 */
function submitForm(formulaire, url, target) {
	if(url) {
		$(formulaire).attr("action", url);
		$(formulaire).attr("target", target);
	}
	$(formulaire).submit();
}

function goToUrl(url) {
	document.forms[0].action = url;
	document.forms[0].submit();
}

/**
 * Gestion des popins
 */
function processPopins() {
	$("a.iframe").fancybox({					
		'width' : 500,
		'height' : 500,
		'padding' : 0,
		'margin' : 0,					
		'hideOnContentClick': false,
		'hideOnOverlayClick' : false,
		'centerOnScroll' : true
	});
}

/*******************************************************************************
 * Documents ready
 ******************************************************************************/
/**
 * cette fonction permet d'activer l'affichage de la popup de de demande
 * d'enregistrement des modifications � la sortie des �crans.
 */
function setChangeDataVar(value){
	changeData = value;
}
$(document).ready(function() {  

	/**
	 * parametres personnalises pour les popin
	 */
	$('span.iframe').replaceWith(function() {
	    var url = $(this).attr('title');
		var texte = $.trim($(this).text());
	    return '<a href="' + url + '" title="' + texte + '" class="lien iframe">' + texte + '</a>';
	});

	/**
	 * gestion boutons radios categories
	 */
	$("#liste_categorie_0").click(function() {
		$("#categorie_0").attr('checked', true);
		$("#categorie_1").attr('checked', false);
	});
	$("#liste_categorie_1").click(function() {
		$("#categorie_0").attr('checked', false);
		$("#categorie_1").attr('checked', true);
	});

	// Gestion des popions
	processPopins();
	
	/**
	 * Gestion des accordeons
	 */
	$('.acc_container').hide();
	$('.acc_container_fils').hide();
	$('.acc_trigger_fullscreen').addClass('active').next().show();
	// $('.acc_trigger:first').addClass('active').next().show();

	$('.acc_trigger').click(function() {
		if ($(this).next().is(':hidden')) {
			$('.acc_trigger').removeClass('active').next().slideUp('fast');
			$(this).toggleClass('active').next().slideDown('fast');
		} else {
			$(this).removeClass('active').next().slideUp('fast');
		}
		return false;
	});

	$('.acc_trigger_fils').click(function() {
		if ($(this).next().is(':hidden')) {
			$('.acc_trigger_fils').removeClass('active').next().slideUp('fast');
			$(this).toggleClass('active').next().slideDown('fast');
		} else {
			$(this).removeClass('active').next().slideUp('fast');
		}
		return false;
	});
	
	$('.acc_trigger_fullscreen').click(function() {
		if ($(this).next().is(':hidden')) {
			$('.acc_trigger','.acc_trigger_fullscreen').removeClass('active').next().slideUp('fast');
			$(this).toggleClass('active').next().slideDown('fast');
		} else {
			$(this).removeClass('active').next().slideUp('fast');
		}
		return false;
	});

	/**
	 * Selection automatique du contenu des champs input
	 */
	$("input[type='text']").on("click", function () {
	   $(this).select();
	});

	// on centre les checkbox dans les tableaux
	centerCheckboxes();
	
	// selection du contenu des inputs text
	inputFocus();
});



