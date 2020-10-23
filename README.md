# 타자 연습 프로그램 mini-project
- **bitcamp-200713 1차 미니 프로젝트** (20200909 ~ 20200910)

## Control
```
### typing(타자연습)
 - /typing/phoneticSymbol : 자리 연습
 - /typing/word : 짧은 글 연습
 - /typing/sentence : 긴 글 연습
 
### member (사용자관리)
 - /member/my : 현재 사용자 정보
 - /member/add : 사용자 등록
 - /member/list : 사용자 목록 조회
 - /member/update : 사용자 정보 변경
 - /member/delete : 사용자 삭제
 
### setting (설정)
 - /setting/list : 설정 조회
 - /setting/userNo : 사용자 설정
 - /setting/testNumber : 테스트 횟수 
```

## Source

### src/main/java/mini/project/domain
Member.java
 - 사용자 no(번호), name(이름), accuracy(정확도), testCount(테스트 한 횟수) 인스턴스 변수 정의
 - no, name, accuracy, testCount 변수의 Setter/Getter 메서드 정의
 
Setting.java
 - userNo, userName, testNumber 스태틱 변수 정의
 - userNo, userName, testNumber 변수의  Setter/Getter 메서드 정의

### src/main/java/mini/project/Handler
MemberHandler.java
 - my() : 현재 사용자 정보 조회 메서드
 - add() : 사용자 등록 메서드
 - list() : 사용자 목록 조회 메서드
 - update() : 사용자 정보 변경 메서트
 - delete() : 사용자 삭제 메서드
 
SettingHandler.java
 - show() : 설정 조회 메서드
 - userNo() : 사용자 설정 메서드
 - testNumber() : 테스트 횟수 설정 메서드
 
TypingHandler.java
 - phoneticSymbol() : 자리 연습 메서드
 - word() : 낱말 연습 메서드
 - sentence() : 짧은 글 연습 메서드

### src/main/java/mini/project/util
Prompt.java
 - inputString() : String 값 입력받는 메서드
 - inputInt() : Int 값 입력받는 메서드
 - close() : System.in 입력 스트림 자원 해제 메서드

### src/main/java/mini/project/App.java
 - main()
