package com.currency.converter.convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/")
public class CurrencyController {

	public CurrencyController() {
		// TODO Auto-generated constructor stub
	}

@GetMapping("/")
public String getrupee(Model model) throws JsonParseException, JsonMappingException, MalformedURLException, IOException{
	System.out.println("hi");
	model.addAttribute("formPOJO",new FormPOJO());

	model.addAttribute("answer",0);
	return "Home";

}

@PostMapping("/converter")
public String getconverter(@ModelAttribute("formPOJO") FormPOJO fp,Model model) throws JsonParseException, JsonMappingException, MalformedURLException, IOException{
	String fromCurr= fp.getFromCurr();
	String toCurr= fp.getToCurr();
	//api to get data
	String url ="http://apilayer.net/api/live?access_key=41e1ff43c22bd55821492d60c97329ee&source=USD&currencies="+toCurr+"&format=1";
	
	ObjectMapper mapper = new ObjectMapper();
	
	System.out.println(url);
	//type Reference is used to map json to MAP.
	Map<String,Object> m = mapper.readValue(new URL(url), new TypeReference<Map<String,Object>>(){});
	System.out.println("fullmap : "+m);
	
	
	Map<String,Object> ans=(Map<String,Object>)m.get("quotes");
	System.out.println("quotes : "+m.get("quotes"));
	System.out.println(ans.get(fromCurr+""+fp.toCurr));
	

	double answer=Double.parseDouble(ans.get(fp.getFromCurr()+""+fp.getToCurr())+"")*Double.valueOf(fp.getFromValue());
	
	model.addAttribute("answer",answer);
	return "Home";

}

}
