package cn.aberic.fabric.controller;

import cn.aberic.fabric.thrift.MultiServiceProvider;
import cn.aberic.thrift.peer.PeerInfo;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 *
 * @author : Aberic 【2018/6/4 15:01】
 */
@CrossOrigin
@RestController
@RequestMapping("peer")
public class PeerController {

    @Resource
    private MultiServiceProvider multiSService;

    @GetMapping(value = "listAll")
    public List<PeerInfo> listAll() {
        try {
            return multiSService.getPeerService().listAll();
        } catch (TException e) {
            e.printStackTrace();
        }
        return null;
    }

}