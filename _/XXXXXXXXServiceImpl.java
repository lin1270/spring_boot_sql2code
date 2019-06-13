package XXXXXXXX_PACKAGE.service.impl;

import com.pactera.jep.orm.mybatis.mapper.Mapper;
import com.pactera.jep.orm.mybatis.service.MyBatisCRUDService;
import XXXXXXXX_PACKAGE.mapper.XXXXXXXXMapper;
import XXXXXXXX_PACKAGE.model.XXXXXXXX;
import XXXXXXXX_PACKAGE.service.XXXXXXXXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class XXXXXXXXServiceImpl
        extends MyBatisCRUDService<XXXXXXXX, String>
        implements XXXXXXXXService
{
    @Autowired
    private XXXXXXXXMapper mapper;

    @Override
    public Mapper<XXXXXXXX,String> getMapper() { return mapper; }
}
