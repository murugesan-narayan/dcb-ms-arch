package com.muru.dcb.user.vo;

import com.muru.dcb.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {
    private Map<String, Object> department;
    private User user;
}
