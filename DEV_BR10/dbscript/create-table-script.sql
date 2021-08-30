DROP TABLE BR_USER;
DROP TABLE BR_ORDER;
DROP TABLE BR_ACCOUNT;
DROP TABLE GIFT;
DROP TABLE ICE_SIZE_PRICE;
DROP TABLE INO;
DROP TABLE MANAGER;
DROP TABLE PAY;
DROP TABLE PAYMENT;
DROP TABLE PRODUCT;
DROP TABLE PRODUCT_CATEGORY;

CREATE TABLE BR_ACCOUNT (
   A_DATE VARCHAR2(30) CONSTRAINT PK_A_DATE PRIMARY KEY,
   A_ACCOUNT NUMBER CONSTRAINT NN_A_ACOCOUNT NOT NULL
);

COMMENT ON COLUMN BR_ACCOUNT.A_DATE IS '날짜';
COMMENT ON COLUMN BR_ACCOUNT.A_ACCOUNT IS '정산금액';

CREATE TABLE PRODUCT_CATEGORY (
   CATEGORY_CODE NUMBER CONSTRAINT PK_CATEGORY_CODE PRIMARY KEY,
   CATEGORY_NAME VARCHAR2(30)
);

COMMENT ON COLUMN PRODUCT_CATEGORY.CATEGORY_CODE IS '카테고리코드';
COMMENT ON COLUMN PRODUCT_CATEGORY.CATEGORY_NAME IS '카테고리이름';

CREATE TABLE PRODUCT (
   PRODUCT_NUM NUMBER CONSTRAINT PK_PRODUCT_NUM PRIMARY KEY,
   PRODUCT_NAME VARCHAR2(50),
   PRODUCT_PRICE NUMBER,
   CATEGORY_CODE NUMBER CONSTRAINT NN_CATEGORY_CODE NOT NULL,
   STOCK NUMBER,
   CONSTRAINT FK_CATEGORY_CODE FOREIGN KEY(CATEGORY_CODE) 
   REFERENCES PRODUCT_CATEGORY(CATEGORY_CODE)
);

COMMENT ON COLUMN PRODUCT.PRODUCT_NUM IS '상품번호';
COMMENT ON COLUMN PRODUCT.PRODUCT_NAME IS '상품명';
COMMENT ON COLUMN PRODUCT.PRODUCT_PRICE IS '상품가격';
COMMENT ON COLUMN PRODUCT.CATEGORY_CODE IS '카테고리코드';
COMMENT ON COLUMN PRODUCT.STOCK IS '재고';


CREATE TABLE ICE_SIZE_PRICE (
   SZIE_NUM NUMBER CONSTRAINT PK_SIZE_NUM PRIMARY KEY,
   SIZE_NAME VARCHAR2(30) CONSTRAINT NN_SIZE_NAME NOT NULL,
   SIZE_PRICE NUMBER CONSTRAINT NN_SIZE_PRICE NOT NULL
);

COMMENT ON COLUMN ICE_SIZE_PRICE.SZIE_NUM IS '사이즈번호';
COMMENT ON COLUMN ICE_SIZE_PRICE.SIZE_NAME IS '사이즈명';
COMMENT ON COLUMN ICE_SIZE_PRICE.SIZE_PRICE IS '가격';

CREATE TABLE INO (
   INO_NUM NUMBER CONSTRAINT PK_INO_NUM PRIMARY KEY,
   INO VARCHAR2(30),
   QTY NUMBER,
   PRODUCT_NUM NUMBER CONSTRAINT NN_PRODUCT_NUM NOT NULL,
   CONSTRAINT FK_PRODUCT_NUM FOREIGN KEY (PRODUCT_NUM)
   REFERENCES PRODUCT(PRODUCT_NUM)
);

COMMENT ON COLUMN INO.INO_NUM IS '입출고번호';
COMMENT ON COLUMN INO.INO IS '입출고';
COMMENT ON COLUMN INO.QTY IS '수량';
COMMENT ON COLUMN INO.PRODUCT_NUM IS '상품번호';

CREATE TABLE BR_USER (
   PHONE_NUM VARCHAR2(30) CONSTRAINT PK_PHONE_NUM PRIMARY KEY,
   POINT NUMBER,
   PHONE_CO VARCHAR2(30)
);

COMMENT ON COLUMN BR_USER.PHONE_NUM IS '핸드폰번호';
COMMENT ON COLUMN BR_USER.POINT IS '포인트점수';
COMMENT ON COLUMN BR_USER.PHONE_CO IS '통신사';

CREATE TABLE BR_ORDER (
   ORDER_SEQ NUMBER CONSTRAINT PK_ORDER_SEQ PRIMARY KEY,
   PRODUCT_NUM NUMBER CONSTRAINT NN_PRODUCT_NUM1 NOT NULL,
   PHONE_NUM VARCHAR2(30),
   ORDER_NUM NUMBER CONSTRAINT NN_ORDER_NUM NOT NULL,
   QTY NUMBER CONSTRAINT NN_QTY NOT NULL,
   PAYMENT VARCHAR2(1)CONSTRAINT NN_PAYMENT NOT NULL,
   CONSTRAINT FK_PRODUCT_NUM1 FOREIGN KEY(PRODUCT_NUM) 
   REFERENCES PRODUCT(PRODUCT_NUM),
   CONSTRAINT FK_PHONE_NUM FOREIGN KEY(PHONE_NUM)
   REFERENCES BR_USER(PHONE_NUM)
);

COMMENT ON COLUMN BR_ORDER.ORDER_SEQ IS '주문_일련번호';
COMMENT ON COLUMN BR_ORDER.PRODUCT_NUM IS '상품번호';
COMMENT ON COLUMN BR_ORDER.PHONE_NUM IS '핸드폰번호';
COMMENT ON COLUMN BR_ORDER.ORDER_NUM IS '주문번호';
COMMENT ON COLUMN BR_ORDER.QTY IS '수량';
COMMENT ON COLUMN BR_ORDER.PAYMENT IS '결제상태';

CREATE TABLE PAYMENT (
   PAYMENT_NUM NUMBER CONSTRAINT PK_PAYMENT_NUM PRIMARY KEY,
   PAYMENT_NAME VARCHAR2(20) CONSTRAINT NN_PAYMNET_NAME NOT NULL
);

COMMENT ON COLUMN PAYMENT.PAYMENT_NUM IS '결제수단구분번호';
COMMENT ON COLUMN PAYMENT.PAYMENT_NAME IS '수단명';

CREATE TABLE PAY (
   PAY_NUM NUMBER ,
   PAY_TIME VARCHAR2(30),
   PHONE_NUM VARCHAR2(30),
   PAY_TOTAL NUMBER CONSTRAINT NN_PAY_TOTAL NOT NULL,
   PAYMENT_NUM NUMBER,
   CONSTRAINT PK_PAY_NUM_PAY_TIME PRIMARY KEY(PAY_NUM, PAY_TIME),
   CONSTRAINT FK_PHONE_NUM1 FOREIGN KEY(PHONE_NUM)
   REFERENCES BR_USER(PHONE_NUM),
   CONSTRAINT FK_PAYMENT_NUM FOREIGN KEY(PAYMENT_NUM)
   REFERENCES PAYMENT(PAYMENT_NUM)
);

COMMENT ON COLUMN PAY.PAY_NUM IS '결제번호';
COMMENT ON COLUMN PAY.PHONE_NUM IS '핸드폰번호';
COMMENT ON COLUMN PAY.PAY_TIME IS '결제시간';
COMMENT ON COLUMN PAY.PAY_TOTAL IS '총결제금액';
COMMENT ON COLUMN PAY.PAYMENT_NUM IS '결제수단구분번호';

CREATE TABLE MANAGER (
   MANAGER_KEY VARCHAR2(20) CONSTRAINT PK_MANAGER_KEY PRIMARY KEY
);

COMMENT ON COLUMN MANAGER.MANAGER_KEY IS '관리자키';

CREATE TABLE GIFT (
   GIFT_NUM NUMBER CONSTRAINT PK_GIFT_NUM PRIMARY KEY,
   GIFT_USE VARCHAR2(30) CONSTRAINT NN_GIFT_USE NOT NULL
);

COMMENT ON COLUMN GIFT.GIFT_NUM IS '기프티콘 번호';
COMMENT ON COLUMN GIFT.GIFT_USE IS '기프티콘 사용여부';

ALTER TABLE BR_ORDER
ADD CONSTRAINT CK_PAYMENT CHECK(PAYMENT IN ('Y','N'));

ALTER TABLE GIFT
ADD CONSTRAINT CK_GIFT_USE CHECK(GIFT_USE IN ('Y','N'));


-- [INSERT] --

-- MANAGER --
INSERT 
  INTO MANAGER
VALUES 
(
  '0000'
);

-- PRODUCT_CATEGORY --
INSERT
  INTO PRODUCT_CATEGORY
(
  CATEGORY_CODE,
  CATEGORY_NAME
)
VALUES
(
  1
, '아이스크림'
);

INSERT
  INTO PRODUCT_CATEGORY
(
  CATEGORY_CODE,
  CATEGORY_NAME
)
VALUES
(
  2
, '케이크'
);

INSERT
  INTO PRODUCT_CATEGORY
(
  CATEGORY_CODE,
  CATEGORY_NAME
)
VALUES
(
  3
, '디저트'
);

INSERT
  INTO PRODUCT_CATEGORY
(
  CATEGORY_CODE,
  CATEGORY_NAME
)
VALUES
(
  4
, '음료'
);

INSERT
  INTO PRODUCT_CATEGORY
(
  CATEGORY_CODE,
  CATEGORY_NAME
)
VALUES
(
  5
, 'MD'
);

-- ICE_SIZE_PRICE --
INSERT
  INTO ICE_SIZE_PRICE
(
  SZIE_NUM,
  SIZE_NAME,
  SIZE_PRICE
)
VALUES
(
  1
, '싱글콘'
, 3200
);

INSERT
  INTO ICE_SIZE_PRICE
(
  SZIE_NUM,
  SIZE_NAME,
  SIZE_PRICE
)
VALUES
(
  2
, '더블콘'
, 4300
);

INSERT
  INTO ICE_SIZE_PRICE
(
  SZIE_NUM,
  SIZE_NAME,
  SIZE_PRICE
)
VALUES
(
  3
, '파인트'
, 8200
);
INSERT
  INTO ICE_SIZE_PRICE
(
  SZIE_NUM,
  SIZE_NAME,
  SIZE_PRICE
)
VALUES
(
  4
, '쿼터'
, 15500
);

INSERT
  INTO ICE_SIZE_PRICE
(
  SZIE_NUM,
  SIZE_NAME,
  SIZE_PRICE
)
VALUES
(
  5
, '패밀리'
, 22000
);


INSERT
  INTO ICE_SIZE_PRICE
(
  SZIE_NUM,
  SIZE_NAME,
  SIZE_PRICE
)
VALUES
(
  6
, '하프갤런'
, 26000
);

-- BR_ACCOUNT --
INSERT
  INTO BR_ACCOUNT
(
  A_DATE
, A_ACCOUNT
)
VALUES
(
  TO_CHAR(SYSDATE+1,'yyyy.mm.dd hh24:mi')
, '10000'
);

-- BR_USER --
INSERT 
  INTO BR_USER
VALUES 
(
  '01012341234'
, 291
, 'KT'
);

INSERT 
  INTO BR_USER
VALUES 
(
  '01011112222'
, 90
, 'SK'
);

INSERT 
  INTO BR_USER
VALUES 
(
  '01023331111'
, 99
, 'LG'
);

INSERT 
  INTO BR_USER
VALUES 
(
  '01088889999'
, 453
, 'KT'
);

INSERT 
  INTO BR_USER
VALUES 
(
  '01044443333'
, 93
, 'SK'
);

-- PRODUCT --
INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  1
, '바람과 함께 보여지다'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  2
, '민트초코칩'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  3
, '피스타 아몽드'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  4
, '제주녹차티'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  5
, '아빠도 외계인'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  6
, '체리마루'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  7
, '쿠키 앤 크림'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  8
, '사과민트'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  9
, '바나나 꿀단지'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  10
, '자모카 모카'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  11
, '이상한 왕국의 솜사탕'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  12
, '베리베리 빨간베리'
, NULL
, 1
, 10
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  13
, '라이언일병 파티'
, 30000
, 2
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  14
, '별빛이 내린다'
, 21000
, 2
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  15
, '아이스 후르츠 와츄원 NO.6'
, 25000
, 2
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  16
, '해피해피 뽀로로친구들'
, 28000
, 2
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  17
, '아이스바나나킥'
, 3000
, 3
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  18
, '아이스롤리 - 바닐라'
, 4000
, 3
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  19
, '아이스 모찌모찌 초코'
, 5000
, 3
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  20
, '아이스 롤케이크 - 체리'
, 5500
, 3
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  21
, '아메리카노'
, 1500
, 4
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  22
, '아이스 아메리카노'
, 2000
, 4
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  23
, '바닐라 라떼'
, 2500
, 4
, 5
);

INSERT
  INTO PRODUCT
(
  PRODUCT_NUM
, PRODUCT_NAME
, PRODUCT_PRICE
, CATEGORY_CODE
, STOCK
)
VALUES
(
  24
, '아이스 바닐라 라떼'
, 3000
, 4
, 5
);

INSERT
  INTO PRODUCT
VALUES
(
  25
, 'MD_PINK'
, 6000
, 5
, 5
);

INSERT
  INTO PRODUCT
VALUES
(
  26
, 'MD_BLUE'
, 6000
, 5
, 5
);
-- GIFT --
INSERT
  INTO GIFT 
(
  GIFT_NUM,
  GIFT_USE
)
VALUES
(
   1
, 'Y'

);

INSERT
  INTO GIFT 
(
  GIFT_NUM,
  GIFT_USE
)
VALUES
(
   2
, 'Y'

);

INSERT
  INTO GIFT 
(
  GIFT_NUM,
  GIFT_USE
)
VALUES
(
   3
, 'Y'

);
INSERT
  INTO GIFT 
(
  GIFT_NUM,
  GIFT_USE
)
VALUES
(
   4
, 'Y'

);
INSERT
  INTO GIFT 
(
  GIFT_NUM,
  GIFT_USE
)
VALUES
(
   5
, 'Y'

);

-- PAYMENT --
INSERT
  INTO PAYMENT
(
  PAYMENT_NUM
, PAYMENT_NAME
)
VALUES
(
  1
, 'QR'
);

INSERT
  INTO PAYMENT
(
  PAYMENT_NUM
, PAYMENT_NAME
)
VALUES
(
  2
, '기프티콘'
);

ALTER TABLE BR_ORDER
ADD CONSTRAINT CK_PAYMENT CHECK(PAYMENT IN ('Y','N'));

ALTER TABLE GIFT
ADD CONSTRAINT CK_GIFT_USE CHECK(GIFT_USE IN ('Y','N'));

COMMIT;