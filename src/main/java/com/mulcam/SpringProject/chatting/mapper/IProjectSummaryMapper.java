package com.mulcam.SpringProject.chatting.mapper;

import java.util.Map;

public interface IProjectSummaryMapper {

	Map<String, Object> selectJoinMemberListWithProfileImgByGroupNo(int groupNo);

}
