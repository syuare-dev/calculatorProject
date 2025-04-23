package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

    // 저장된 결과값 조회 (캡슐화를 위해 복사본으로 생성 후 조회되도록 함)
    public List<String> getResultList() {
        //return resultList; // resultList에 직접 접근 가능 > 캡슐화(private) 의미가 없어져 수정 필요 ↓
        return new ArrayList<>(resultList); // resultList의 값을 가진 신규 배열 생성 > 복사본으로 사용

    }

    // 저장된 결과값 전체 출력 (복사본 getResultList()를 활용)
    public void printResultList() {
        System.out.println("========== 계 산 기 록 ==========");
        for (String list : getResultList() ) {
            System.out.println(list);
        }
    }

    // Scanner 입력값보다 저장된 결과값이 클 경우면 출력 > Lambda & Stream 활용
    public List<String> getResultLargerThanInput(double InputValue) {
        if(getResultList().isEmpty()){ // resultList에 저장된 값이 없을 경우 예외 처리
            throw new NoSuchElementException("저정된 결과값이 없어 비교가 불가능합니다.");
        }
        //Lambda&Stream 사용 코드
        return getResultList().stream() // 데이터 준비: stream()
                .filter(num -> Double.parseDouble(num.replace(",","")) > InputValue) // 중간 연산 등록(num 값(String -> double 형 변환) 과 InputValue 값과 비교하여, num 값 보다 높은 값만 필터해둠
                .collect(Collectors.toList()); // 최종 연산 > 컬렉터를 활용하여 List로 반환(return)하겠다.

        // Lambda&Stream 사용하지 않은 코드
//        List<String> stream = new ArrayList<>();
//        for(String num1 : getResultList()) {
//            double num2 = Double.parseDouble(num1.replace(",",""));
//            if(num2 > InputValue) {
//                stream.add(num1);
//            }
//        }
//        return stream;
    }

}
