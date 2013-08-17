package com.hrxc.auction.action;

import com.hrxc.auction.dao.ClientSideDao;
import com.hrxc.auction.domain.ClientSide;
import com.hrxc.auction.domain.vo.ClientSideVo;
import com.hrxc.auction.util.UITools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class ClientSideAction {

    private static final Logger log = Logger.getLogger(ClientSideAction.class);
    private static final ClientSideDao dao = new ClientSideDao();

    /**
     * 根据项目编号获取项目信息
     *
     * @param clientNo
     * @return
     */
    public static ClientSide getClientSideByClientNo(String clientNo) {
        ClientSide dto = null;
        try {
            ClientSideVo condition = new ClientSideVo();
            condition.setClientNo(clientNo);
            List<ClientSide> list = dao.getAllObjectInfo(condition);
            if (list != null && list.size() > 0) {
                dto = list.get(0);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return dto;
    }

    /**
     * 根据条件查询数据信息
     *
     * @return
     */
    public static Object[][] getAllTableData(ClientSideVo condition) {
        Object[][] data = null;
        try {
            List<ClientSide> list = dao.getAllObjectInfo(condition);
            if (list != null && list.size() > 0) {
                data = List2TableData(list);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }

    /**
     * 获取所有委托方信息
     *
     * @return
     */
    public static HashMap<String, String> getAllClientInfo() {
        HashMap<String, String> dataMap = new HashMap<String, String>();
        try {
            List<ClientSide> list = dao.getAllObjectInfo(new ClientSideVo());
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    ClientSide dto = list.get(i);
                    dataMap.put(dto.getClientNo(), dto.getClientName());
                }
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return dataMap;
    }

    private static Object[][] List2TableData(List<ClientSide> list) {
        Object[][] data = new Object[list.size()][ClientSideTableConfig.tableColumnNames.length];
        for (int i = 0; i < list.size(); i++) {
            int seq = 0;
            ClientSide dto = list.get(i);
            data[i][seq++] = null;
            data[i][seq++] = dto.getPkId();
            data[i][seq++] = String.valueOf(i + 1);
            data[i][seq++] = dto.getClientNo();
            data[i][seq++] = dto.getClientName();
        }
        return data;
    }

    /**
     * 保存或新增数据信息
     *
     * @param dto
     */
    public static void saveOrUpdateObject(ClientSide dto) {
        try {
            if (StringUtils.isNotEmpty(dto.getPkId())) {
                dao.updateObjectById(dto);
            } else {
                dto.setPkId(UITools.generateUUID());
                dao.insertObject(dto);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }

    /**
     * 根据主键查询数据信息
     *
     * @param pkId
     * @return
     */
    public static ClientSide getObjectById(String pkId) {
        ClientSide dto = null;
        try {
            dto = dao.getObjectById(pkId);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return dto;
    }

    /**
     * 主键集合删除数据信息
     *
     * @param list
     */
    public static void deleteObjectById(ArrayList<String> list) {
        try {
            dao.deleteObjectById(list);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }
}
