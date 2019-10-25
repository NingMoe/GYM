package com.gym.service;

import com.github.pagehelper.PageInfo;
import com.gym.pojo.itemState;

public interface ManageService {

	PageInfo<itemState> findPageObjects(String name, Integer pageCurrent, Integer state);
}
