package com.coffee.a9;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 自定义参数类型转换
 * http://localhost:8080/Springbase/app/a9?S2D=2020-09-01
 * @author coffeeliu
 *
 */
@Controller
public class a9Controller
{

	@GetMapping("/a9")
	public ResponseEntity<String> info(Date S2D) 
	{		
		return ResponseEntity.ok()
				.header("Content-Type", "text/plain;charset=utf-8")
				.body("OK, 已设置截止日期: " + S2D);
	}

	

}
