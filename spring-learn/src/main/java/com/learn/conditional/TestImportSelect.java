package com.learn.conditional;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 批量导入组件
 * @author: peijiepang
 * @date 2019-08-27
 * @Description:
 */
public class TestImportSelect implements ImportSelector {

	/**
	 *
	 * @param importingClassMetadata @import的注解信息
	 * @return
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.learn.bean.Person"};
	}
}
