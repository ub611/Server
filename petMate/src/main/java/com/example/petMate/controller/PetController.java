package com.example.petMate.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.petMate.domain.Pet;
import com.amazonaws.services.waf.model.HTTPRequest;
import com.example.petMate.domain.Adopt;
import com.example.petMate.service.PetMateFacade;

@Controller
public class PetController {

	private static Logger logger = LoggerFactory.getLogger(PetController.class);

	@Autowired
	private PetMateFacade petMate;
	
	String user_u_idx = "2"; //req.getSession().getAttribute("u_idx")
	
	// 입양게시글 리스트
	
	@RequestMapping(value="/adoptList.do", method=RequestMethod.GET)
	public String listAdopts(Model model) throws Exception {

		List<Adopt> adoptList = petMate.selectAdoptList();
		logger.info("\n"+ adoptList.toString());
		
//		Map<Integer, List<String>> petInfos = new HashMap<>();
//		for (Adopt adopt:  adoptList) {
//			List<String> petInfo = new ArrayList<String>();
//			petInfo.add(petMate.selectPetNameByAdopt(adopt.getPet_p_idx()));
//			petInfo.add(petMate.selectPetAgeByAdopt(adopt.getPet_p_idx()));
//			petInfo.set(0, petMate.selectPetNameByAdopt(adopt.getPet_p_idx()));
//			petInfo.set(1, petMate.selectPetAgeByAdopt(adopt.getPet_p_idx()));
//			petInfos.put(adopt.getA_idx(), petInfo); 
//		}
		
		model.addAttribute("adoptList", adoptList);
//		model.addAttribute("petList", petInfos);
//		model.addAttribute("petImages", petImages);
		return "/adoptList";
	}
	
	// 입양게시글 상세보기
	@RequestMapping(value="/adoptDetail.do", method=RequestMethod.GET)
	public String detailAdopt(@RequestParam int a_idx, Model model) throws Exception {
		Adopt adoptDetail = petMate.selectAdoptByIdx(a_idx);
		model.addAttribute("adoptDetail", adoptDetail);
		model.addAttribute("petDetail", petMate.selectPetByIdx(adoptDetail.getA_idx()));
		return "/adoptDetail";
	}
	
	// 분양할 펫 등록
	@RequestMapping(value="/petRegister.do", method=RequestMethod.GET)
	public String registerPet() {
		return "/petRegister";
	}
	@RequestMapping(value="/petRegister.do", method=RequestMethod.POST)
	public String createPet(HttpServletRequest req, Pet pet, Model model) throws Exception { 
		
		pet.setUser_u_idx(user_u_idx); //req.getSession().getAttribute("user_u_idx")
		petMate.insertPet(pet);
		
		Adopt adopt = new Adopt();
		adopt.setA_date(new Date());
		adopt.setA_state(0); // 0:입양가능, 1:입양완료,
		adopt.setPet_p_idx(petMate.selectPetIdxLatest());
		adopt.setOwner_idx(user_u_idx); 
		adopt.setA_title(pet.getP_name() + ":: " + pet.getP_cate_detail());
		adopt.setA_content(req.getParameter("a_content"));
		
		petMate.insertAdopt(adopt);
		return "redirect:petList.do?u_idx=" + user_u_idx;		
	}
	
	// 분양할 펫 수정
	@RequestMapping(value="/petEdit.do", method=RequestMethod.GET)
	public String editPet(@RequestParam int p_idx, Model model) throws Exception {
		logger.info("\n" + String.valueOf(p_idx));
		model.addAttribute("pet", petMate.selectPetByIdx(p_idx));
		model.addAttribute("adopt", petMate.selectAdoptByPet(p_idx));
		return "/petRegister";
	}
	@RequestMapping(value="/petEdit.do", method=RequestMethod.POST)
	public String editPet(HttpServletRequest req, Model model) throws Exception { 
		logger.info("\n*****PetController::editPet:: " + req.getParameter("p_idx"));
		
		Pet pet = new Pet();
		pet.setP_idx(Integer.parseInt(req.getParameter("p_idx")));
		pet.setP_age(Integer.parseInt(req.getParameter("p_age")));
		pet.setP_gender(Integer.parseInt(req.getParameter("p_gender")));
		pet.setP_isInjection(Integer.parseInt(req.getParameter("p_isInjection")));
		pet.setP_cate(Integer.parseInt(req.getParameter("p_cate")));
		pet.setP_cate_detail(req.getParameter("p_detail_cate"));
		
		//logger.info("\n*****AdoptController::updateAdopt:: " + adopt.getA_content() + ":: " + adopt.getA_title());
		
		petMate.updatePet(pet);
		
		Adopt adopt = new Adopt();
		adopt.setA_date(new Date());
		adopt.setA_state(0); // 0:입양가능, 1:입양완료,
		adopt.setPet_p_idx(pet.getP_idx());
		adopt.setOwner_idx(user_u_idx); 
		adopt.setA_title(pet.getP_name() + ":: " + pet.getP_cate_detail());
		adopt.setA_content(req.getParameter("a_content"));
		petMate.updateAdopt(adopt);
		
		return "redirect:petList.do?u_idx=" + user_u_idx;		
	}
	
	// 분양할 펫 삭제
	@RequestMapping(value="/petDeleteConfirm.do", method=RequestMethod.GET)
	public String removePetConfirm(@RequestParam int p_idx, Model model) throws Exception {
		model.addAttribute("p_idx", p_idx);
		model.addAttribute("u_idx", user_u_idx);
		return "/petDelete";
	}
	@RequestMapping(value="/petDelete.do", method=RequestMethod.GET)
	public String removePet(HttpServletRequest req) throws Exception {
		logger.info("\n"+req.getParameter("p_idx").toString());
		petMate.deleteAdoptByPet(Integer.parseInt(req.getParameter("p_idx")));
		petMate.deletePet(Integer.parseInt(req.getParameter("p_idx")));
		return "redirect:petList.do?u_idx=" + user_u_idx;	
	}
	
	// 유저가 등록한 펫 리스트
	@RequestMapping(value="/petList.do", method=RequestMethod.GET)
	public String listPets(@RequestParam int u_idx, Model model) throws Exception {
		model.addAttribute("petList", petMate.selectPetByUserIdx(u_idx)); 
		return "/petList";
	}
	
	
}
