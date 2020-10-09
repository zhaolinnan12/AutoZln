package Core.Abstract;

import Core.Interface.autoGenerationVaule;
import Enum.functionEnum;
import org.apache.poi.ss.formula.functions.T;

public abstract class abstractAutoGenValue implements autoGenerationVaule<String>{
    protected abstract functionEnum getfunctionEnum(String keywords);

    protected abstract String getParameter(String keywords);
    @Override
    public String GenerationValue(String Keywords) {
        String Paramter =null;
        functionEnum functionEnum=getfunctionEnum(Keywords);
        Paramter =getParameter(Keywords);
        if (functionEnum !=null){
            if (Paramter !=null){
                return  functionEnum.generateValue(Paramter);
            }else {
                return  functionEnum.generateValue(null);
            }
        }

    }

}
