package com.adjava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@Autowired
	LoginModel lm;
	
	@RequestMapping("/")
	public String showLogin(Model m)
	{
		/* m.addAttribute("loginattribute", new Login()); */
		return "Home1";
	}
	
	@RequestMapping("login")
	public String checkLogin(@ModelAttribute("bean")Login obj,Model m)
	{
		String s=lm.check(obj);
		if(s.equals("login"))
		{
			/* m.addAttribute("loginattribute", new Login()); */
			return "userlogin";
		}
		else {
			if((obj.name.equals("admin"))&& (obj.pwd.equals("admin")))
				{
			return "adminbook";
				}
			else 			
					return "login";	}						
	}

	@RequestMapping("register")
	public String savevalues(@ModelAttribute("reg")Login r,Model m)
	{
		lm.insertValues(r);
		m.addAttribute("registerattribute",new Login());
		return "Success";
	}

	@RequestMapping("newbook")
	public String insert(@ModelAttribute("ins")Book b,Model m)
	{
		lm.insertBook(b);
		m.addAttribute("newbookattribute",new Book());
		return "BookSuccess";
	}
	@RequestMapping("delbook")
	public String delete(@ModelAttribute("delbookattribute")Book b,Model m)
	{
		lm.deleteBook(b);
		m.addAttribute("delbookattribute",new Book());
		return "delBookSuccess";
    
}
	@RequestMapping("bookdetails")
	public String search(@ModelAttribute("searchbookattribute")Book b,Model m)
	{
		String st=lm.searchbook(b);
		System.out.println(b.getBookname());
		if(st.equals("unavailable"))
		{
			m.addAttribute("searchattribute",new Book());
			System.out.println("Book  Available");
			return"unavailable";
		}
	return "available";
	}
	
	
	
	@RequestMapping("viewbook")
	public String bookview(@ModelAttribute("buk")Book d,Model m)
	{
		List<Book> li=lm.bookdetails(d);
		m.addAttribute("list",li);
		return"viewbook";
	}
	
	@RequestMapping("userlist")
	public String booklist(@ModelAttribute("buk")Book d,Model m)
	{
		List<Book> lii=lm.bookdetails(d);
		m.addAttribute("list",lii);
		return"userlist";
	}
	
}






