package Enum;

import Core.Interface.generateByParameter;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;


public enum functionEnum implements generateByParameter {
    uuid {
        @Override
        public String generateValue(String Parameter) {
            return IdUtil.simpleUUID();
        }
    },
    random {
        @Override
        public String generateValue(String Keywords) {

            if (Keywords != null) {
                return Convert.toStr(RandomUtil.randomInt(Integer.parseInt(Keywords)));
            } else {
                return Convert.toStr(RandomUtil.randomInt());
            }
        }
    }
}
