package com.sean.Languages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sean.Languages.models.language;

@Service
public class LangService {
	List<language> languages = new ArrayList<language>(Arrays.asList(
			new language("Java", "Sean", "3.0"),
			new language("Python", "Captain", "2.0"),
			new language("Javascript", "John", "1.5")));
	
	public List<language>allLangs(){
		return languages;
	}
	public void addLang(language languagez) {
//		languagez.setName("name");
//		languagez.setCreator("creator");
//		languagez.setVersion("version");
		languages.add(languagez);
		
		System.out.println(languages);
	}
	public void updateLang(int id, language languagez) {
		language oldLanguage = languages.get(id);
		oldLanguage.setCreator(languagez.getCreator());
		oldLanguage.setName(languagez.getName());
		oldLanguage.setVersion(languagez.getVersion());
		languages.set(id, languagez);
				
		
	}
	public language findLanguageByIndex(int id) {
		return languages.get(id);
		
	}
	public void delete(int id) {
		languages.remove(id);
	}
}
