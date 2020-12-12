package com.mybatis.v2.dao;

import com.mybatis.v2.anno.TulingSelect;
import com.mybatis.v2.entity.ProductInfo;
import org.springframework.stereotype.Component;

/**
 * [来个全套]
 *
 * @slogan: 高于生活，源于生活
 * @Description: TODO
 * @author: smlz
 * @date 2020/5/4 15:01
 */

public interface ProductMapper {

	@TulingSelect(value = "select * from product_info where product_id=?")
	ProductInfo qryProductInfoById(Integer productId);
}
