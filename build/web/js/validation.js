/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var deptList=[
  ["mdept","dept"  ],
  ["test","test"  ],
  ["Sweater","Sweater"  ],
  ["Sewing","Sewing- Unit 5 (Hanger)"  ],
  ["Security ","Security & Fire safety"  ],
  ["Security ","Security & Fire safety (Monitoring Cell)"  ],
  ["Sample","Sample"  ],
  ["Sample","Sample (fabric)"  ],
  ["R. Q. S","R.Q.S."  ],
  ["Quality Assurance","Quality assurance (MQI) "  ],
  ["Quality Assurance","Quality assurance "  ],
  ["Purchase And Procurement","Purchase & Procurement "  ],
  ["Printing","Printing (design)"  ],
  ["Printing","Printing"  ],
  ["Planning","Planning"  ],
  ["Personnel and Management","Personal Management"  ],
  ["Merchandising","Merchandising"  ],
  ["Maintenance","Maintenance"  ],
  ["Maintenance","Civil"  ],
  ["Knitting","Knitting section "  ],
  ["Knitting","Knitting section (Steel) "  ],
  ["IT","IT"  ],
  ["Inventory","Inventory"  ],
  ["Inventory","Inventory (Chemical)"  ],
  ["Inventory","Inventory (Steel)"  ],
  ["Inventory","Inventory (Tally section)"  ],
  ["Inventory","Inventory (Spare Parts)"  ],
  ["Internal Audit","Internal Audit"  ],
  ["IE and Planning","IE Planning"  ],
  ["HRD","HRD"  ],
  ["Garments","Garments (Maintenance)"  ],
  ["Garments","Garments"  ],
  ["G.P.Q","GPQ"  ],
  ["Finishing","Finishing"  ],
  ["Export","Export "  ],
  ["Embroidery","Embroidery"  ],
  ["Dyeing","Dyeing"  ],
  ["Cutting","Cutting- Unit 2"  ],
  ["Cutting","Cutting- Unit 4"  ],
  ["Cutting","Cutting "  ],
  ["Compliance","Compliance"  ],
  ["Commercial","Commercial"  ],
  ["Commercial","Dhaka Office"  ],
  ["CAD","CAD        "  ],
  ["Admin","Admin"  ],
  ["Accounts","Accounts"  ]
];


function searchItem2(){
	var item= document.getElementById('mdept').value;
        
        //clear the previous option list
        
	document.getElementById('dept').options.length = 1;
    
	//var test=
	//alert(item);
	//alert(customers[1][1]);
	var result=[];
	for(i=1; i<deptList.length; i++){
		if(item === deptList[i][0]){
			result.push([deptList[i][1]]);
			//alert(customers[0][i]);
	
		}
	}
	
	var select = document.getElementById("dept");
	
	/*var length1 = select.options.length;
	alert(length1);
	alert(result.length);
	for (i = 1; i < length1; i++) {
	  select.options[i] = null;
	}*/

	for(var i = 0; i < result.length; i++) {
		var opt = result[i];
		var el = document.createElement("option");
		el.textContent = opt;
		el.value = opt;
		select.appendChild(el);
	}
        
        var oldItem=item;
	
	//result=[];

}


function typeChange(){
    /*var mtype= document.getElementById("mtype").value;
    if(mtype==="Printer" || mtype==="Camera" || mtype==="Scanner" || mtype==="Plotter"){
         document.getElementById("idtype").setAttribute("style","display: none;");
         //document.getElementById("idtype").value = "none";
         document.getElementById("idlebel").setAttribute("style","display: none;");
         document.getElementById("depttype").removeAttribute("style");
         document.getElementById("deptlebel").removeAttribute("style");
    }else{
        document.getElementById("depttype").setAttribute("style","display: none;");
        document.getElementById("deptlebel").setAttribute("style","display: none;");
        document.getElementById("idtype").removeAttribute("style");
        document.getElementById("idlebel").removeAttribute("style");
     
     }
     
     */
    
    var utype= document.getElementById("utype").value;
    
    if (utype==="Dept") {
        
        document.getElementById("idtype").setAttribute("style","display: none;");
         //document.getElementById("idtype").value = "none";
        document.getElementById("idlebel").setAttribute("style","display: none;");
        document.getElementById("depttype").removeAttribute("style");
        document.getElementById("deptlebel").removeAttribute("style");
        
    } else {
        
        document.getElementById("depttype").setAttribute("style","display: none;");
        document.getElementById("deptlebel").setAttribute("style","display: none;");
        document.getElementById("idtype").removeAttribute("style");
        document.getElementById("idlebel").removeAttribute("style");
        
    }
    
    
    
    
    
    
}


function log(){
    
     //getting field value
    var aname=document.getElementById("aname");
    var password=document.getElementById("password");
    
    
     //checking for null
    if (aname.value == "") {
        sweetAlert("Enter User Name");
        aname.focus();
        
        return false;
        
    }
    
    
    if (password.value == "") {
        sweetAlert("Enter User Password");
        password.focus();
        
        return false;
        
    }
    
    
}


function logClose() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   window.location.href = 'index.jsp';
    
}





function addM(){
    
    //confirmButtonColor("#8CD4F5");
    
    //getting field value
    var id=document.getElementById("id");
    var ip=document.getElementById("ip");
    var suplrwrnty=document.getElementById("suplrwrnty");
    var prdtlife=document.getElementById("prdtlife");
    //var buydate=document.getElementById("buydate");
    var pid="test";
    pid=document.getElementById("pid");
    
      
    
    
    //checking for null
    if (id.value == "") {
        sweetAlert("Enter ID");
        id.focus();
        return false;
        
    }
    
    
    
     if (ip.value == "") {
        sweetAlert("Enter IP");
        ip.focus();
        return false;
        
    }
    
     if (suplrwrnty.value == "") {
        sweetAlert("Enter Supplier Warrenty");
        suplrwrnty.focus();
        return false;
        
    }
    
     if (prdtlife.value == "") {
        sweetAlert("Enter Product Lifetime");
        prdtlife.focus();
        return false;
        
    }
    
     /*if (buydate.value == null) {
        sweetAlert("Enter Product Purchase Date");
        buydate.focus();
        return false;
        
    }*/
    
     if (pid.value == "") {
        sweetAlert("Enter Product ID");
        pid.focus();
        return false;
        
    }

    
}



function addMS(){
    
    //confirmButtonColor("#8CD4F5");
    
    //getting field value
    var id=document.getElementById("id");
    var ip=document.getElementById("ip");
    var suplrwrnty=document.getElementById("suplrwrnty");
    var prdtlife=document.getElementById("prdtlife");
    //var buydate=document.getElementById("buydate");
    var pid="test";
    pid=document.getElementById("pid");
    
      
    
    
    //checking for null
    if (id.value == "") {
        sweetAlert("Enter ID");
        id.focus();
        return false;
        
    }
    
    
    
     if (ip.value == "") {
        sweetAlert("Enter IP");
        ip.focus();
        return false;
        
    }
    
     if (suplrwrnty.value == "") {
        sweetAlert("Enter Supplier Warrenty");
        suplrwrnty.focus();
        return false;
        
    }
    
     if (prdtlife.value == "") {
        sweetAlert("Enter Product Lifetime");
        prdtlife.focus();
        return false;
        
    }
    
     /*if (buydate.value == null) {
        sweetAlert("Enter Product Purchase Date");
        buydate.focus();
        return false;
        
    }*/
    
     if (pid.value == "") {
        sweetAlert("Enter Product ID");
        pid.focus();
        return false;
        
    }

    
}



function addME(){
    
    //confirmButtonColor("#8CD4F5");
    
    //getting field value
    var id=document.getElementById("id");
    var ip=document.getElementById("ip");
    var suplrwrnty=document.getElementById("suplrwrnty");
    var prdtlife=document.getElementById("prdtlife");
    //var buydate=document.getElementById("buydate");
    var pid="test";
    pid=document.getElementById("pid");
    
      
    
    
    //checking for null
    if (id.value == "") {
        sweetAlert("Enter ID");
        id.focus();
        return false;
        
    }
    
    
    
     if (ip.value == "") {
        sweetAlert("Enter IP");
        ip.focus();
        return false;
        
    }
    
     if (suplrwrnty.value == "") {
        sweetAlert("Enter Supplier Warrenty");
        suplrwrnty.focus();
        return false;
        
    }
    
     if (prdtlife.value == "") {
        sweetAlert("Enter Product Lifetime");
        prdtlife.focus();
        return false;
        
    }
    
     /*if (buydate.value == null) {
        sweetAlert("Enter Product Purchase Date");
        buydate.focus();
        return false;
        
    }*/
    
     if (pid.value == "") {
        sweetAlert("Enter Product ID");
        pid.focus();
        return false;
        
    }

    
}



function mbuy(){
    
    //getting field value
    var id=document.getElementById("id");
    var ip=document.getElementById("ip");
    var suplrwrnty=document.getElementById("suplrwrnty");
    var prdtlife=document.getElementById("prdtlife");
    //var buydate=document.getElementById("buydate");
    var pid="test";
    pid=document.getElementById("pid");
    
    
    
    //checking for null
    if (pid.value == "") {
        sweetAlert("Enter ID");
        pid.focus();
        return false;
        
    }
    
    
    
    
    
}


function searchEntryS(){
    
     //getting field value
    var id=document.getElementById("id");
    var ip=document.getElementById("ip");
    
    
     //checking for null
    if ((id.value == "")&&(ip.value == "")) {
        sweetAlert("You have to input either ID or IP for search");
        id.focus();
        ip.focus();
        return false;
        
    }
    
    
}


function searchEntryU(){
    
     //getting field value
    var id=document.getElementById("id");
    var ip=document.getElementById("ip");
    
    
     //checking for null
    if (id.value == "") {
        sweetAlert("ID can't be left Blank");
        id.focus();
        return false;
        
    }
    
     if (ip.value == "") {
        sweetAlert("IP can't be left Blank");
        ip.focus();
        return false;
        
    }
    
}


function addEmp(){
    
     //getting field value
    var id=document.getElementById("id");
    
    
    
     //checking for null
    if (id.value == "") {
        sweetAlert("Enter ID");
        id.focus();
        return false;
        
    }
    
}


function DeleteChck(){
    
     //getting field value
    var pcstatus=document.getElementById("pcstatus");
    var remarks=document.getElementById("remarks");
    
    
     //checking for null
    if (pcstatus.value == "") {
        sweetAlert("Select Status");
        id.focus();
        return false;
        
    }
    
    
    if (remarks.value == "") {
        sweetAlert("Add Remarks");
        id.focus();
        return false;
        
    }
    
}


function report1(){
    
     //getting field value
    var id=document.getElementById("id");
     var dept=document.getElementById("dept");
   
     //checking for null
    if ((id.value == "") && (dept.value == "")) {
        sweetAlert("Enter ID Or Select Department");
        id.focus();
        return false;
        
    }
    
}

function report2(){
    
     //getting field value
   
    var dept=document.getElementById("dept");
    
     //checking for null
    if (dept.value == "") {
        sweetAlert("Select a Department");
        dept.focus();
        return false;
        
    }
    
}

function report3(){
    
     //getting field value
    var pid=document.getElementById("pid");
    
     //checking for null
    if (pid.value == "") {
        sweetAlert("Enter Product ID");
        pid.focus();
        return false;
        
    }
    
}


function report4(){
    
    var id=document.getElementById("id");
    var ip=document.getElementById("ip");
    var fklid=document.getElementById("fklid");
    
    if(((id.value!= "")&&(ip.value!= ""))  ||
       ((id.value!= "")&&(fklid.value!= ""))  ||
       ((fklid.value!= "")&&(ip.value!= ""))){
        sweetAlert("Please, Input only one among ID/IP/Tag");
        
        return false;
        
    }
    
    
}

function checkDept(){
    
    //alert("ok");
    
    var mdept=document.getElementById("mdept");
    var dept=document.getElementById("dept");
   
    
    if(((mdept.value!= "")&&(dept.value!= ""))){
        
        //sweetAlert("Please, Input only one between Dept and Subdept!");
        mdept.value= "";
        
        
    }
    
    
}


function addMClose() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'addM.jsp';
    
}



function addMErrClose() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'addM.jsp';
    
}


function addEmpN() {
    window.location.href = 'addM.jsp';
}

function addEmpY() {
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location='newEmp';
    
}

function searchCloseS() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'searchEntry.jsp';
    
}

function searchCloseE() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'searchEntry.jsp';
    
}


function empCloseE() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'addEmp.jsp';
    
}


function empCloseS() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'addEmp.jsp';
    
}

function mbuyCloseE() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   window.location.href = 'mbuy.jsp';
    
}

function mbuyCloseS() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   window.location.href = 'mbuy.jsp';
    
}

function createUserSuccClose() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'addEmp.jsp';
    
}



function createUserErrClose() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'addEmp.jsp';
    
}


function deleteCloseE() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   window.location.href = 'deleteEntry.jsp';
    
}


function deleteCloseS() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'deleteEntry.jsp';
    
}

function deletePrntrCloseE() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   //window.location.href = 'deleteEntryP.jsp';
    
}

function deletePrntrCloseS() {
    
   document.getElementById("msuccess").setAttribute("style","display: none");
   document.getElementById("msuccess1").setAttribute("style","display: none");
   window.location.href = 'deleteEntryP.jsp';
    
}