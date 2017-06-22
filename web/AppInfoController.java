package cn.springlogic.appinfo.web;

import cn.springlogic.appinfo.jpa.entity.Protocol;
import cn.springlogic.appinfo.jpa.repository.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2017/6/15.
 */
@RequestMapping("api")
@Controller
public class AppInfoController {

    @Autowired
    private ProtocolRepository appInfoRepository;

    @GetMapping("/appinfo/protocol/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        try {
            /** 获取文章 **/
            Protocol protocol = appInfoRepository.findOne(id);
            Assert.notNull(protocol, "文章不见了...");

            /** 装载文章数据 **/
            model.addAttribute("protocol", protocol);

        } catch (Exception e) {
            return "common/404";
        }
        return "protocol/common";
    }
}

