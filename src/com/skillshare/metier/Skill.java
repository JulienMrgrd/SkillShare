package com.skillshare.metier;

public enum Skill {
	
	// Informatique
	ASSEMBLEUR("Assembleur"),
	ANDROID("Android"),
	C("C"),
	C_PLUS_PLUS("C++"),
	C_SHARP("C#"),
	COFFEESCRIPT("CoffeeScript"),
	CSS("CSS"),
	GO("Go"),
	GROOVY("Groovy"),
	HTML("HTML"),
	JAVA("Java"),
	JAVASCRIPT("Javascript"),
	NOSQL("NoSQL"),
	OBJECTIVE_C("Objective-C"), 
	OCAML("OCAML"),
	PASCAL("Pascal"),
	PERL("Perl"),
	PHP("PHP"),
	PROLOG("Prolog"),
	PYTHON("Python"), 
	RESEAUX("Réseaux"),
	RUBY("Ruby"),
	SCHEME("Scheme"),
	SHELL("Shell"),
	SQL("SQL"),
	SWIFT("Swift"),
	VISUAL_BASIC("Visual Basic"),
	WEB("Web");
	
	private String realName;
	
	private Skill(String name) {
		this.setName(name);
	}

	public String getName() {
		return realName;
	}

	public void setName(String name) {
		this.realName = name;
	}

}
