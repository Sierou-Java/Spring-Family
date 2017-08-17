package org.sierou.fastdfs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author xiaocai
 * 2016-10-17
 *
 */
@Controller
@RequestMapping("/fastdfs")
public class Web {

	@RequestMapping("")
    public String index() {
		return "index";
    }
	
}
