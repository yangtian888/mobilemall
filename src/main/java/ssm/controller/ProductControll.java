package ssm.controller;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.entity.Product;
import ssm.entity.Sort;
import ssm.entity.User;
import ssm.service.ProductService;
import ssm.service.SortService;


public class ProductControll {
	@Autowired
	   private ProductService productService;
	@Autowired
	private SortService sortService;
	
	private String uploadDir = "";
	
	@RequestMapping(method=RequestMethod.POST,value="/product-new")
	public String createPro(@ModelAttribute Product pro,@RequestParam(required=false)String sortId,
			Model model){
		if(pro.getPrint().getSize()==0|| pro.getPrint().getContentType().toLowerCase().startsWith("/image")){
		}else{
			try {
				String filename = System.currentTimeMillis()+pro.getPrint().getOriginalFilename();
				pro.getPrint().transferTo(new File(uploadDir, filename));
				pro.setPrintUrl(filename);
				System.out.println(pro);
				productService.createProduct(pro,sortId);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return "redirect:/prolist";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/product")
	public String product(Model model){
		List<Sort> sorts = sortService.findAll();
		model.addAttribute("sorts", sorts);
		return "vip-product";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/prolist")
	public String prolist(Model model){
		List<Product> pros = productService.findAll();
		model.addAttribute("pros", pros);
		return "prolist";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/buyinfo/{id}")
	public String detail(@PathVariable Long id,Model model){
		Product pro = productService.detail(id);
		model.addAttribute("pro", pro);
		return "buyinfo";
	}
}
