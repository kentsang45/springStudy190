package org.kent.controller;

import java.util.ArrayList;
import java.util.List;

import org.kent.domain.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {
	
	// GET 방식 호출
	@GetMapping("/api/list")
	public List<Store> getList(){
		List<Store> stores = new ArrayList<>();
		
		stores.add(Store.builder().name("로리스 더 프라임").lat(37.498150).lng(127.026200).build());
		stores.add(Store.builder().name("뚜레쥬르").lat(37.499612).lng(127.027181).build());
		stores.add(Store.builder().name("카페더스노우").lat(37.507013).lng(127.026528).build());
		stores.add(Store.builder().name("카페 마마스").lat(37.496390).lng(127.025560).build());
		stores.add(Store.builder().name("후와후와").lat(37.5276311308612).lng(126.9247329947).build());
		stores.add(Store.builder().name("도피오로스터리").lat(37.505326).lng(127.022188).build());
		stores.add(Store.builder().name("Chloris Tea Rooms").lat(37.504024).lng(127.025525).build());
		stores.add(Store.builder().name("Keopibin").lat(37.502466).lng(127.024828).build());
		stores.add(Store.builder().name("그레이스케일커피").lat(37.503462).lng(127.028282).build());
		stores.add(Store.builder().name("맘마미아").lat(37.525905385032885).lng(127.03464565651308).build());

		return stores;
	}
	
}
