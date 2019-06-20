package com.example.petMate.dao.mybatis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.petMate.dao.AdoptDao;
import com.example.petMate.dao.mybatis.mapper.AdoptMapper;
import com.example.petMate.domain.Adopt;

@Repository
public class MybatisAdoptDao implements AdoptDao {
	
	private static Logger logger = LoggerFactory.getLogger(MybatisAdoptDao.class);
	
	@Autowired
	private AdoptMapper adoptMapper;

	@Override
	public List<Adopt> selectAdoptList() {
		return adoptMapper.selectAdoptList();
	}

	@Override
	public Adopt selectBoardByIdx(int a_idx) {
		return adoptMapper.selectAdoptByIdx(a_idx);
	}

	@Override
	public Adopt selectAdoptByPet(int pet_p_idx) {
		return adoptMapper.selectAdoptByPet(pet_p_idx);
	}
	
	@Override
	public int insertAdopt(Adopt adopt) {
		logger.info("\n*****MybatisAdoptDao::insertAdopt:: " + adopt.getA_content() + ":: " + adopt.getA_title());
		
		return adoptMapper.insertAdopt(adopt);
	}

	@Override
	public int updateAdopt(Adopt adopt) {
		return adoptMapper.updateAdopt(adopt);
	}

	@Override
	public int deleteAdopt(int a_idx) {
		return adoptMapper.deleteAdopt(a_idx);
	}

	@Override
	public int deleteAdoptByPet(int p_idx) {
		return adoptMapper.deleteAdoptByPet(p_idx);
	}

}
