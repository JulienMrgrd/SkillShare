function Skill(skill,level){
	this.skill = skill;
	this.id = "id" + skill;
	this.level = level;
}

Skill.prototype.getLevelLabel = function()
{
	if(this.level==1) 	return 'Base';
	if(this.level==2) 	return 'Avancé';
	if(this.level == 3) return 'Expert';
}

Skill.prototype.getHTML = function (){
	var result =  "<li id='";
	result += this.id + "' class='skill-item'>";
	result += this.skill + " " + this.getLevelLabel();
	result += "<a onClick=\"deleteSkill('"+ this.id + "')\"> Supprimer</a></li>";
	return result;
}

Skill.prototype.toJson = function(){
	return {
		skill:this.skill,
		level:this.level
	};
}

var userSkills=[];

var userSkills = initUserSkills();
//
//
//function initUserSkills()
//{
//	userSkills = [new Skill('C',1), new Skill('C_SHARP', 2)];
//	for(i=0; i<userSkills.length; i++)
//	{
//		$('#skillList').append(userSkills[i].getHTML());
//	}
//
//	return userSkills;
//}

function initUserSkills()
{
	$('#skillList li').each(function (i) {

        var index = $(this).index();
        var text = $(this).text();
        var value = $(this).attr('value');
        var elem = value.split('--');
        
    	var newSkill = new Skill(elem[0],elem[1]);
    	userSkills.push(newSkill);
    });
	
	return userSkills;


}

function deleteSkill(id){
	$('#'+id).remove();
	var index;
	for(i=0; i<userSkills.length; i++){
		if(userSkills[i].id == id){
			index = i;
			break;
		}
	}
	userSkills.splice(index, 1);
}

function addSkill(){
	var skill = $("#skillItem option:selected").val();
	var level = $("#skillLevel option:selected").val();
	var newSkill = new Skill(skill,level);
	for(i=0; i<userSkills.length; i++){
		if(userSkills[i].id == newSkill.id){
			alert(skill + " already exists in the list");
			return;
		}
	}
	userSkills.push(newSkill);
	$('#skillList').append(newSkill.getHTML());	
}

//userSkills = initUserSkills();

function Modif()
{

//	var success = function(){
//		//window.location.replace("main.jsp");
//		alert ("success");
//	}
//	
//
//
//	var error = function(){
//		alert('error');
//	}

	var data = {
			lastname : document.getElementById('lastname').value,
			firstname : document.getElementById('firstname').value,
			email : document.getElementById('email').value,
			password : document.getElementById('password').value,
			skills : JSON.stringify(userSkills)	
	}
	

	
	$.ajax
	({
		type: "POST",
		url : "update",
		data : data,
		dataType : 'JSON',
		success : function(data) 
		{

			var resultat = data;



        	if (resultat.message==1)
			{
                alert ("Votre profil a été modifié");
        		window.location.replace("modifProfil.jsp");
			}

		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}



