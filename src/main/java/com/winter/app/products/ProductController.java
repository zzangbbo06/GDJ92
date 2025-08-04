package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value="/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public void list(Model model) throws Exception {
		List<ProductVO> list = productService.list();
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("detail")
	public void detail(ProductVO productVO, Model model) throws Exception {
		ProductVO detail = productService.detail(productVO);
		
		model.addAttribute("detail", detail);
		
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		return "products/product_form";
	}
	@PostMapping("add")
	public String add(ProductVO productVO) throws Exception{
		int result = productService.add(productVO);
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update(ProductVO productVO, Model model) throws Exception{
		ProductVO detail = productService.detail(productVO);
		model.addAttribute("detail", detail);
		return "products/product_form";
	}
	@PostMapping("update")
	public String update1(ProductVO productVO, Model model) throws Exception{
		int result = productService.update(productVO);
		
		String msg = "수정 실패";
		
		if(result > 0) {
			msg = "수정 성공";
		}
		
		String url="./detail?productNum="+productVO.getProductNum();
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		return "commons/result";
	}
}
