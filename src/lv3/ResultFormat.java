package lv3;

import java.text.DecimalFormat;

// 결과값을 원하는 형식으로 변경 클래스
public class ResultFormat {

    // 계산 결과값 형식 변환 기능
    public String formattedResult(double result) {
        DecimalFormat dfResult = new DecimalFormat("#,###.###############");
        return dfResult.format(result); // 결과값을 형식 변경 후 formattedResult에 반환
    }
}
