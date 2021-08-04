
# WsBoardTest

> SSR방식, SPA방식의 게시판 성능비교를 위한 샘플자료입니다.

<img width="1920" alt="SSR 게시판" src="https://user-images.githubusercontent.com/32568291/128248325-d7540326-5a78-43b1-8a03-72fb7b712c0b.png">


## 배경 🤔
 > SSR방식과 CSR(SPA)방식의 UX적인 차이를 체감하고, SPA 형식의 게시판에서 HTTP통신과 websocket 통신의 성능적 차이점을 찾아보기 위하여 해당 프로젝트를 구성하였습니다.
 > 
 > 해당 테스트에서는 3가지 형태의 게시판을 사용합니다. **첫 번째 게시판은** JSP로 구성된 **SSR방식**의 게시판입니다. **두 번째 게시판은** React로 구성된 **CSR방식**의 SPA 게시판입니다. 마지막 **세 번째 게시판**은 두번째와 동일하지만 **모든 서버와의 통신을  websocket을 통해 처리합니다.**

## 방법 🧐
1. 3가지 형태의 게시판을 구성 ( SSR, SPA, SPA + websocket only)
2. 크로미움의 Headless기능을 통해 게시판 별로 게시글을 1000개씩 작성
3. 게시판 형식 별 게시글 작성 속도 측정


## 과정 😗
![image](https://user-images.githubusercontent.com/32568291/128248577-f38d795e-1271-4ca2-9dec-a93d52a8cbf4.png)

> 게시판 생성 기능을 크로미움의 Headless를 통해 빠르게 생성합니다!

<img width="1920" alt="스크린샷 2021-08-05 오전 4 07 58" src="https://user-images.githubusercontent.com/32568291/128249305-816e8cbd-026b-4341-9352-eb17f1e2dc3f.png">

> 잘 생성되고 있군요! 이제 생성된 시간을 통해 결과를 도출해 보겠습니다.

![image](https://user-images.githubusercontent.com/32568291/128250250-17e1d8c3-ec32-4f42-8842-0ad37ffbcec4.png)

> 해당 차트는 각 유형별로 게시물 100개를 생성한 밀리세컨드 수치입니다. 10번씩 총 3000개의 게시물을 만들어 봤는데요 CSR(SPA)방식이 SSR 보다 확실히 빠르게 생성된 것을 확인할 수 있습니다. 하지만 아쉽게도 HTTP통신과 websocket통신의 속도 차이점은 이번 테스트를 통해 알아볼수는 없었네요 😭

## 결과
SPA방식은 빠른 전환속도를 통해 훌륭한 UX를 제공한다!


### IDE
 - eclips(4.11.0)

### Tech Stack
 - React
 - JSP
 - Mysql
 - Spring
 - ES2015+
