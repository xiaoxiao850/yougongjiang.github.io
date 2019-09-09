/**
 * 
 */
package com.hpe.service.impl;

import java.util.List;

import com.hpe.dao.ITypesDao;
import com.hpe.dao.impl.TypesDaoImpl;
import com.hpe.pojo.Types;
import com.hpe.service1.ITypesService;



/** 
 * 类描述：
 * 作者： shenqiutong 
 * 创建日期：2019年9月3日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */
public class TypesServiceImpl implements ITypesService{
	private ITypesDao typesDao=new TypesDaoImpl();
	@Override
	public List<Types> getTypesAll(){
		
		return typesDao.getTypesAll();
	}
	@Override
	public int addTypes(Types types){
		Types type=typesDao.getTypesByName(types.getName());
		if(type!=null){
			return -1;
		}
		return typesDao.addTypes(types);
	}
	//修改
	public  int updateTypes(Types types) {
		//根据id查询
		Types ty=typesDao.getTypesbyId(types.getId());
		if(ty.getName().equals(types.getName())){
			return 1;
		}
		//根据name查询
		Types type=typesDao.getTypesByName(types.getName());
		if(type!=null){
			return -1;
		}
		return 0;
	}
		//根据id查询
	public Types getTypesbyId(int id) {
			return typesDao.getTypesbyId(id);
	}
}
