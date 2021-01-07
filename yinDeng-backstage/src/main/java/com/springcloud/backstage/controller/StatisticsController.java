package com.springcloud.backstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("statistics")
public class StatisticsController {

	@RequestMapping("charts-1")
	public String charts1() {
		return "charts-1";
	}
	@RequestMapping("charts-2")
	public String charts2() {
		return "charts-2";
	}
	@RequestMapping("charts-3")
	public String charts3() {
		return "charts-3";
	}
	@RequestMapping("charts-4")
	public String charts4() {
		return "charts-4";
	}
	@RequestMapping("charts-5")
	public String charts5() {
		return "charts-5";
	}
	@RequestMapping("charts-6")
	public String charts6() {
		return "charts-6";
	}
	@RequestMapping("charts-7")
	public String charts7() {
		return "charts-7";
	}
}
