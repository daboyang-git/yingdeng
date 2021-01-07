package com.springcloud.common.client;


import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "GOODS")
public interface GoodsServiceClient {

	/*	*//**
			 * get方式路径传值
			 * 
			 * @param goodsId
			 * @return
			 */
	/*
	 * @RequestMapping(value="/goods/goodsInfo/{goodsId}" , method =
	 * RequestMethod.GET) public Result goodsInfo(@PathVariable("goodsId") String
	 * goodsId);
	 * 
	 *//**
		 * 测试传Map,都是String
		 * 
		 * @param map
		 * @return
		 */
	/*
	 * @RequestMapping(value="/goods/goodInfo",method = RequestMethod.POST) public
	 * Result goodInfo(@RequestParam Map<String, Object> map);
	 * 
	 *//**
		 * 测试传多个参数
		 * 
		 * @param goodsId
		 * @param oderId
		 * @return
		 */
	/*
	 * @RequestMapping(value="/goods/goods",method = RequestMethod.POST) public
	 * Result goods(@RequestParam("goodsId") String goodsId,@RequestParam("orderId")
	 * String oderId);
	 * 
	 *//**
		 * 测试传Map,带自定义对象
		 * 
		 * @param map
		 * @return
		 */
	/*
	 * @RequestMapping(value="/goods/goodMapObjectInfo",method = RequestMethod.POST)
	 * public Result goodMapObjectInfo(@RequestParam Map<String,Object> map);
	 * 
	 *//**
		 * 测试传Object
		 * 
		 * @param order
		 * @return
		 *//*
			 * @RequestMapping(value="/goods/goodForObject",method = RequestMethod.POST)
			 * public Result goodForObject(@RequestBody Order order);
			 */
}
