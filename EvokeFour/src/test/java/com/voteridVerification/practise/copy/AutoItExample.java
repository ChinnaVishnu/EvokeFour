package com.voteridVerification.practise.copy;
import java.io.File;

import org.testng.annotations.Test;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;
public class AutoItExample {


	@Test
	public void init(){
		//Intialization 
		File file  = new File("./src/test/resources/jacob-1.14.3-x64.dll");
		System.setProperty(LibraryLoader.JACOB_DLL_PATH,file.getAbsolutePath() );
		AutoItX auto = new AutoItX();
		
		auto.send("#r",false);
		sleep(2);
		auto.send("notepad");
		auto.send("{ENTER}",false);
		
		auto.winActivate("Untitled - Notepad");
		System.out.println(auto.winWaitActive("Untitled - Notepad","",5));
		auto.send("Hi this is autoit example");
		auto.send("!{F4}",false);
		auto.winActivate("Notepad");
		auto.controlClick("Notepad", "", "[CLASS:Button; INSTANCE:2]");
	}
	
	public void sleep(int secs){
		try {
			Thread.sleep(1000*secs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
