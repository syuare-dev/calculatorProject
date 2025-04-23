package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// 결과값 조회, 추가, 삭제 등 관리 클래스
public class ResultHistory {

    private final List<String> resultList = new ArrayList<>(); // 결과값을 저장할 리스트



    // 형식이 변화된 결과값을 저장할 수 있는 메서드
    public void addResult (String formattedResult) {
        resultList.add(formattedResult);
    }

    // 결과값 삭제 메서드 (수동, 가장 먼저 저장된 값부터 삭제)
    public String removeResult () {
        if(resultList.isEmpty()) {
            throw new NoSuchElementException("저장된 결과값이 없습니다.");
        }
        return resultList.remove(0);
    }

    // 저장된 결과값 조회
    public List<String> getResultList() {
        //return resultList; // resultList에 직접 접근 가능 > 캡슐화(private) 의미가 없어져 수정 필요 ↓
        return new ArrayList<>(resultList); // resultList의 값을 가진 신규 배열 생성 > 복사본으로 사용

    }

}
