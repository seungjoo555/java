package kr.kh.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.community.dao.ManagerRepository;

@Service
public class ManagerServiceImp implements ManagerService{

	@Autowired
	ManagerRepository managerRepository;
}
