function Skill(skill,level){
	this.skill = skill;
	this.id = "id" + skill;
	this.level = level;
}

Skill.prototype.getHTML = function (){
	var result =  "<li id='";
	result += this.id + "' class='skill-item'>";
	result += this.skill + " " + this.level;
	result += "<a onClick=\"deleteSkill('"+ this.id + "')\">Supprimer</a></li>";
	return result;
}

Skill.prototype.getLevelLabel = function(){
	if(this.level==1)
		return 'Base';
	if(this.level==2);
		return 'Avancé';
	if(this.level == 3)
		return 'Expert';
}

Skill.prototype.toJson = function(){
	return {
		skill:this.skill,
		level:this.level
	};
}



var userSkills = [];

function initUserSkills(){
	userSkills = [new Skill('C',1), new Skill('CSHARP', 2)];
	for(i=0; i<userSkills.length; i++){
		$('#skillList').append(userSkills[i].getHTML());
	}
}

function deleteSkill(id){
	$('#'+id).remove();
	for(i=0; i<userSkills.length; i++){
		if(userSkills[i].id == id){
		}
	}
}

function addSkill(skill,level){}

usersSkills = initUserSkills();