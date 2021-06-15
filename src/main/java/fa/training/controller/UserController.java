package fa.training.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.dto.SearchDTO;
import fa.training.dto.UserDTO;
import fa.training.entities.Company;
import fa.training.entities.Position;
import fa.training.entities.User;
import fa.training.services.impl.CompanyServicesImpl;
import fa.training.services.impl.PositionServicesImpl;
import fa.training.services.impl.UserServicesImpl;

@Controller
public class UserController {
	@Autowired
	UserServicesImpl userServices;

	@Autowired
	PositionServicesImpl positionServices;

	@Autowired
	CompanyServicesImpl comServices;

	public UserController() {
		System.out.println("Ctor UserController");
	}
	
	@GetMapping(value ={"/usermm","/usermm/page/","/usermm/page"})
	public String usermm(HttpSession session, ModelMap map) {
		return "redirect:/usermm/page/1";
	}
	
	
	@GetMapping("/usermm/page/{pagenum}")
//	@ResponseBody
	public String getlistPageUser(@PathVariable("pagenum") int pagenum,HttpSession session, ModelMap map){
		User user = null;
		user = (User) session.getAttribute("User");
		if(user!=null){
			final int sizepage=8;
			int size=(userServices.getAllListUser().size()/sizepage);
			if(pagenum<0 || ((pagenum-1)<0)){
				pagenum=1;
			}
			System.out.print("size :------------------------------------------------------: "+size +"page  -------------------------: "+(pagenum-1) +" \n");
			map.addAttribute("size", size);
			map.addAttribute("page", pagenum);
			List<Position> listPosition = positionServices.getAll();
			List<Company> listCompany = comServices.getAllList();
			map.addAttribute("listCompany", listCompany);
			map.addAttribute("listPosition", listPosition);
			Page<User> pageUser=userServices.paginationUserOld(pagenum-1, sizepage);
			List<User> ss= pageUser.getContent();
			map.addAttribute("listUser", ss);
			if (!map.containsAttribute("UserAdd")) {
				map.addAttribute("UserAdd", new UserDTO());
			}
			if(!map.containsAttribute("FormSearch")) {
				map.addAttribute("FormSearch",new SearchDTO());
			}
			return "usermm";
		}else{
			return "redirect:/login";
		}
	}
	
//	@RequestMapping(value = "/usermm/page/search/}",method = {RequestMethod.GET,RequestMethod.POST})
//	public String search(ModelMap map, HttpSession session,@ModelAttribute("FormSearch") String key) {
//		if(key!=null) {
//			User user = null;
//			user = (User) session.getAttribute("User");
//			if(user!=null){
//				List<Position> listPosition = positionServices.getAll();
//				List<Company> listCompany = comServices.getAllList();
//				map.addAttribute("listCompany", listCompany);
//				map.addAttribute("listPosition", listPosition);
//				List<User> listUser=userServices.paginationAndSearch(index, size, key)
//				
//			}
//			
//		}else {
//			return "redirect:/usermm";
//		}
//	}
	@GetMapping("/search")
	@ResponseBody
	public List<User> getList(){
		return (List<User>) userServices.paginationAndSearch(0, 10, "trung");
	}

	// adduser

	@PostMapping("/usermm/page/adduser")
//	@ResponseBody
	public String adduser(ModelMap map, HttpSession session, @Valid @ModelAttribute("UserAdd") UserDTO dto,
			BindingResult br) {
		User user = null;
		user = (User) session.getAttribute("User");
		if (user != null) {
//			 if(br.hasErrors()){
//				 	return "usermm";
//				 }else{
					 User userNew= new User();
					 userNew.setLoginName(dto.getLoginName());
					 userNew.setPasswordValue(dto.getPassWord());
					 userNew.setFirstName(dto.getFName());
					 userNew.setLastName(dto.getLName());
					 userNew.setEmail(dto.getEmail());
					 userNew.setCellularEmail(dto.getEmail());
					 userNew.setComfirmValue(dto.getConfirmPass());
					 userNew.setModified("NOT ");
					 userNew.setCreated(user.getLastName());
					 userNew.setLastLogin(new Date());
					 userNew.setDisabled("NOT");
					 userNew.setObjectData("NONE");
					 userNew.setPasswordChanged(dto.getPassWord());
					 userNew.setInTelephone(dto.getExPhone1()+dto.getExPhone2()+dto.getExPhone3());
					 userNew.setOutTelephone(dto.getNumOutSide1()+dto.getNumOutSide2()+dto.getNumOutSide3());
					 userNew.setCellularPhone(dto.getOuPhone1());
					 userNew.setFirstNameKana(dto.getFNameKana());
					 userNew.setLastNameKana(dto.getLNameKana());
					 userNew.setCreatedUserId(user.getUserID());
					 Company company= comServices.getByID(Integer.parseInt(dto.getDepartment().get(0)));
					 userNew.setCompany(company);
					 Position position=positionServices.getByID(Integer.parseInt(dto.getPosition()));
					 userNew.setPosition(position);
					 System.out.printf(userNew.toString());
					 userServices.save(userNew);
					 
					 return "redirect:/usermm";
//				 }
		}
		return "login";

	}
	
	@GetMapping("/api")
	@ResponseBody
	public List<User> demoJson(){
		return userServices.getAllListUser();
	}
	@PostMapping("/usermm/page/deleteList")
	@ResponseBody
	public String deleteListUser(HttpSession session,@RequestParam("listUser") String listUser) {
		User user=(User) session.getAttribute("User");
		if(user!=null) {
//			System.out.println("list User  : " +listUser);
			if(listUser!=null) {
				
				String s[]=listUser.split(",");
				for (String string : s) {
					if(checkNum(string) && string!=null) {
						System.out.println(string);
						userServices.delete(Integer.parseInt(string));
					}
				}
				return "true";
			}
		}
		
		return "fasle";
	}
	public boolean checkNum(String num) {
		try {
			int x=Integer.parseInt(num);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@PostMapping("/usermm/page/update")
	@ResponseBody
	public String updateListUser(HttpSession session,@RequestParam("listUser") String listUser,@RequestParam("method") String method) {
		User user=(User) session.getAttribute("User");
		if(user!=null) {
			if(listUser!=null && method!=null) {
				String s[]=listUser.split(",");
				User user2=null;
				if("active".equalsIgnoreCase(method)) {
					
					for (String string : s) {
						if(checkNum(string) && string!=null) {
//							userServices.Active("active", Integer.parseInt(string), user.getUserID());
							user2=userServices.getByID(Integer.parseInt(string));
							if(user2!=null) {
								user2.setDisabled("active");
								user2.setUpdatedUserId(user.getUserID());
								userServices.save(user2);
							}
							user2=null;
						}
					}
				}else if("disable".equalsIgnoreCase(method)){
					for (String string : s) {
						if(checkNum(string) && string!=null) {
//							userServices.Active("disable", Integer.parseInt(string), user.getUserID());
							user2=userServices.getByID(Integer.parseInt(string));
							if(user2!=null) {
								user2.setDisabled("disable");
								user2.setUpdatedUserId(user.getUserID());
								userServices.save(user2);
							}
							user2=null;
						}
					}
				}
				return "true";
			}
			return "fasle";
		}
		
		return "fasle";
	}
	
	
}
