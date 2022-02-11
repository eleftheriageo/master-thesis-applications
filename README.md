# Master-Thesis-Applications
This is the schema of postgreSQL we developed and we need in order to run our project.
At first you need to put this code in your Dbeaver program and also you have to copy and paste it to your postgreSQL server you have at your computer.
<!---It also includes some existed and written by hand users--->

--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2022-01-24 19:57:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 19 (class 2615 OID 17505)
-- Name: master_app; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA master_app;


ALTER SCHEMA master_app OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 278 (class 1259 OID 17516)
-- Name: application; Type: TABLE; Schema: master_app; Owner: postgres
--

CREATE TABLE master_app.application (
    id bigint NOT NULL,
    thesis_degree numeric NOT NULL,
    bachelor_title character varying NOT NULL,
    referral1_id bigint NOT NULL,
    referral2_id bigint NOT NULL,
    student_id bigint NOT NULL,
    master_id bigint NOT NULL
);


ALTER TABLE master_app.application OWNER TO postgres;

--
-- TOC entry 277 (class 1259 OID 17514)
-- Name: application_id_seq; Type: SEQUENCE; Schema: master_app; Owner: postgres
--

CREATE SEQUENCE master_app.application_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE master_app.application_id_seq OWNER TO postgres;

--
-- TOC entry 3142 (class 0 OID 0)
-- Dependencies: 277
-- Name: application_id_seq; Type: SEQUENCE OWNED BY; Schema: master_app; Owner: postgres
--

ALTER SEQUENCE master_app.application_id_seq OWNED BY master_app.application.id;


--
-- TOC entry 285 (class 1259 OID 17568)
-- Name: application_ranking; Type: TABLE; Schema: master_app; Owner: postgres
--

CREATE TABLE master_app.application_ranking (
    id bigint NOT NULL,
    application_id bigint NOT NULL,
    teacher_id bigint NOT NULL,
    ranking integer NOT NULL
);


ALTER TABLE master_app.application_ranking OWNER TO postgres;

--
-- TOC entry 284 (class 1259 OID 17566)
-- Name: application_ranking_id_seq; Type: SEQUENCE; Schema: master_app; Owner: postgres
--

CREATE SEQUENCE master_app.application_ranking_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE master_app.application_ranking_id_seq OWNER TO postgres;

--
-- TOC entry 3143 (class 0 OID 0)
-- Dependencies: 284
-- Name: application_ranking_id_seq; Type: SEQUENCE OWNED BY; Schema: master_app; Owner: postgres
--

ALTER SEQUENCE master_app.application_ranking_id_seq OWNED BY master_app.application_ranking.id;


--
-- TOC entry 287 (class 1259 OID 17588)
-- Name: application_review; Type: TABLE; Schema: master_app; Owner: postgres
--

CREATE TABLE master_app.application_review (
    id bigint NOT NULL,
    application_id bigint NOT NULL,
    secretary_id bigint NOT NULL,
    is_accepted boolean NOT NULL
);


ALTER TABLE master_app.application_review OWNER TO postgres;

--
-- TOC entry 286 (class 1259 OID 17586)
-- Name: application_review_id_seq; Type: SEQUENCE; Schema: master_app; Owner: postgres
--

CREATE SEQUENCE master_app.application_review_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE master_app.application_review_id_seq OWNER TO postgres;

--
-- TOC entry 3144 (class 0 OID 0)
-- Dependencies: 286
-- Name: application_review_id_seq; Type: SEQUENCE OWNED BY; Schema: master_app; Owner: postgres
--

ALTER SEQUENCE master_app.application_review_id_seq OWNED BY master_app.application_review.id;


--
-- TOC entry 281 (class 1259 OID 17536)
-- Name: master; Type: TABLE; Schema: master_app; Owner: postgres
--

CREATE TABLE master_app.master (
    id bigint NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE master_app.master OWNER TO postgres;

--
-- TOC entry 280 (class 1259 OID 17534)
-- Name: master_id_seq; Type: SEQUENCE; Schema: master_app; Owner: postgres
--

CREATE SEQUENCE master_app.master_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE master_app.master_id_seq OWNER TO postgres;

--
-- TOC entry 3145 (class 0 OID 0)
-- Dependencies: 280
-- Name: master_id_seq; Type: SEQUENCE OWNED BY; Schema: master_app; Owner: postgres
--

ALTER SEQUENCE master_app.master_id_seq OWNED BY master_app.master.id;


--
-- TOC entry 283 (class 1259 OID 17545)
-- Name: referral; Type: TABLE; Schema: master_app; Owner: postgres
--

CREATE TABLE master_app.referral (
    id bigint NOT NULL,
    teacher_id bigint NOT NULL,
    student_id bigint NOT NULL,
    text text NOT NULL
);


ALTER TABLE master_app.referral OWNER TO postgres;

--
-- TOC entry 282 (class 1259 OID 17543)
-- Name: referral_id_seq; Type: SEQUENCE; Schema: master_app; Owner: postgres
--

CREATE SEQUENCE master_app.referral_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE master_app.referral_id_seq OWNER TO postgres;

--
-- TOC entry 3146 (class 0 OID 0)
-- Dependencies: 282
-- Name: referral_id_seq; Type: SEQUENCE OWNED BY; Schema: master_app; Owner: postgres
--

ALTER SEQUENCE master_app.referral_id_seq OWNED BY master_app.referral.id;


--
-- TOC entry 276 (class 1259 OID 17506)
-- Name: user; Type: TABLE; Schema: master_app; Owner: postgres
--

CREATE TABLE master_app."user" (
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    type character varying NOT NULL,
    id bigint NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    role character varying NOT NULL,
    username character varying NOT NULL
);


ALTER TABLE master_app."user" OWNER TO postgres;

--
-- TOC entry 279 (class 1259 OID 17520)
-- Name: user_id_seq; Type: SEQUENCE; Schema: master_app; Owner: postgres
--

CREATE SEQUENCE master_app.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE master_app.user_id_seq OWNER TO postgres;

--
-- TOC entry 3147 (class 0 OID 0)
-- Dependencies: 279
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: master_app; Owner: postgres
--

ALTER SEQUENCE master_app.user_id_seq OWNED BY master_app."user".id;


--
-- TOC entry 2966 (class 2604 OID 17519)
-- Name: application id; Type: DEFAULT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application ALTER COLUMN id SET DEFAULT nextval('master_app.application_id_seq'::regclass);


--
-- TOC entry 2969 (class 2604 OID 17571)
-- Name: application_ranking id; Type: DEFAULT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application_ranking ALTER COLUMN id SET DEFAULT nextval('master_app.application_ranking_id_seq'::regclass);


--
-- TOC entry 2970 (class 2604 OID 17591)
-- Name: application_review id; Type: DEFAULT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application_review ALTER COLUMN id SET DEFAULT nextval('master_app.application_review_id_seq'::regclass);


--
-- TOC entry 2967 (class 2604 OID 17539)
-- Name: master id; Type: DEFAULT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.master ALTER COLUMN id SET DEFAULT nextval('master_app.master_id_seq'::regclass);


--
-- TOC entry 2968 (class 2604 OID 17548)
-- Name: referral id; Type: DEFAULT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.referral ALTER COLUMN id SET DEFAULT nextval('master_app.referral_id_seq'::regclass);


--
-- TOC entry 2965 (class 2604 OID 17522)
-- Name: user id; Type: DEFAULT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app."user" ALTER COLUMN id SET DEFAULT nextval('master_app.user_id_seq'::regclass);


--
-- TOC entry 3127 (class 0 OID 17516)
-- Dependencies: 278
-- Data for Name: application; Type: TABLE DATA; Schema: master_app; Owner: postgres
--

INSERT INTO master_app.application VALUES (1, 8.5, 'Bachelor in Computer Science', 1, 2, 1, 1);
INSERT INTO master_app.application VALUES (2, 7, 'Bachelor in Mathematics', 1, 2, 1, 1);


--
-- TOC entry 3134 (class 0 OID 17568)
-- Dependencies: 285
-- Data for Name: application_ranking; Type: TABLE DATA; Schema: master_app; Owner: postgres
--

INSERT INTO master_app.application_ranking VALUES (1, 1, 2, 3);
INSERT INTO master_app.application_ranking VALUES (2, 1, 3, 3);


--
-- TOC entry 3136 (class 0 OID 17588)
-- Dependencies: 287
-- Data for Name: application_review; Type: TABLE DATA; Schema: master_app; Owner: postgres
--



--
-- TOC entry 3130 (class 0 OID 17536)
-- Dependencies: 281
-- Data for Name: master; Type: TABLE DATA; Schema: master_app; Owner: postgres
--

INSERT INTO master_app.master VALUES (1, 'Master in Computer Science and Engineering');


--
-- TOC entry 3132 (class 0 OID 17545)
-- Dependencies: 283
-- Data for Name: referral; Type: TABLE DATA; Schema: master_app; Owner: postgres
--

INSERT INTO master_app.referral VALUES (2, 3, 1, 'Άριστος');
INSERT INTO master_app.referral VALUES (1, 2, 1, 'Πολύ καλός');


--
-- TOC entry 3125 (class 0 OID 17506)
-- Dependencies: 276
-- Data for Name: user; Type: TABLE DATA; Schema: master_app; Owner: postgres
--

INSERT INTO master_app."user" VALUES ('Nikos', 'Nodarakis', 'Student', 4, 'nikos.nodarakis@gmail.com', '$2a$10$qyA5qZ9V88wzUDPOzA8wkuYmaL8cQiz7WdMXbfP4Xb7hecLurabIO', 'ROLE_USER', 'nodarakis2');
INSERT INTO master_app."user" VALUES ('Admin', 'Admin', 'Secretary', 5, 'admin@gmail.com', '$2a$10$p/TqhrqL2KcvEfMmibELueeA5JRD75RueOwQa2GrIKjUC59vn9QlG', 'ROLE_ADMIN', 'admin');
INSERT INTO master_app."user" VALUES ('Nikos', 'Nodarakis', 'Student', 1, 'nikos@gmail.com', '$2a$10$XUAv37JYQZIBtkP2xiy5duThv5A3fzr4/OmLvKc/B8o.XeW49hhFW', 'ROLE_USER', 'nodarakis');
INSERT INTO master_app."user" VALUES ('Giorgos', 'Giorikas', 'Teacher', 2, 'giorgos@gmail.com', '$2a$10$XUAv37JYQZIBtkP2xiy5duThv5A3fzr4/OmLvKc/B8o.XeW49hhFW', 'ROLE_USER', 'giorikas');
INSERT INTO master_app."user" VALUES ('Kostas', 'Kostikas', 'Teacher', 3, 'kostas@gmail.com', '$2a$10$XUAv37JYQZIBtkP2xiy5duThv5A3fzr4/OmLvKc/B8o.XeW49hhFW', 'ROLE_USER', 'kostikas');
INSERT INTO master_app."user" VALUES ('fsdfsdfdsfsd', 'dsfasdgdfgf', 'Student', 7, 'dsafsdf@test.com', '$2a$10$/IsewtKDUWMkYffRFnNJKeS.aDTqXAl3scewRs1R6T57SEIMnx3Ay', 'ROLE_USER', 'username');


--
-- TOC entry 3148 (class 0 OID 0)
-- Dependencies: 277
-- Name: application_id_seq; Type: SEQUENCE SET; Schema: master_app; Owner: postgres
--

SELECT pg_catalog.setval('master_app.application_id_seq', 10, true);


--
-- TOC entry 3149 (class 0 OID 0)
-- Dependencies: 284
-- Name: application_ranking_id_seq; Type: SEQUENCE SET; Schema: master_app; Owner: postgres
--

SELECT pg_catalog.setval('master_app.application_ranking_id_seq', 2, true);


--
-- TOC entry 3150 (class 0 OID 0)
-- Dependencies: 286
-- Name: application_review_id_seq; Type: SEQUENCE SET; Schema: master_app; Owner: postgres
--

SELECT pg_catalog.setval('master_app.application_review_id_seq', 1, false);


--
-- TOC entry 3151 (class 0 OID 0)
-- Dependencies: 280
-- Name: master_id_seq; Type: SEQUENCE SET; Schema: master_app; Owner: postgres
--

SELECT pg_catalog.setval('master_app.master_id_seq', 1, true);


--
-- TOC entry 3152 (class 0 OID 0)
-- Dependencies: 282
-- Name: referral_id_seq; Type: SEQUENCE SET; Schema: master_app; Owner: postgres
--

SELECT pg_catalog.setval('master_app.referral_id_seq', 2, true);


--
-- TOC entry 3153 (class 0 OID 0)
-- Dependencies: 279
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: master_app; Owner: postgres
--

SELECT pg_catalog.setval('master_app.user_id_seq', 7, true);


--
-- TOC entry 2976 (class 2606 OID 17575)
-- Name: application application_pk; Type: CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application
    ADD CONSTRAINT application_pk PRIMARY KEY (id);


--
-- TOC entry 2982 (class 2606 OID 17573)
-- Name: application_ranking application_ranking_pk; Type: CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application_ranking
    ADD CONSTRAINT application_ranking_pk PRIMARY KEY (id);


--
-- TOC entry 2984 (class 2606 OID 17593)
-- Name: application_review application_review_pk; Type: CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application_review
    ADD CONSTRAINT application_review_pk PRIMARY KEY (id);


--
-- TOC entry 2978 (class 2606 OID 17552)
-- Name: master master_pk; Type: CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.master
    ADD CONSTRAINT master_pk PRIMARY KEY (id);


--
-- TOC entry 2980 (class 2606 OID 17550)
-- Name: referral referral_pk; Type: CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.referral
    ADD CONSTRAINT referral_pk PRIMARY KEY (id);


--
-- TOC entry 2972 (class 2606 OID 17530)
-- Name: user user_pk; Type: CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app."user"
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- TOC entry 2974 (class 2606 OID 17670)
-- Name: user user_un; Type: CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app."user"
    ADD CONSTRAINT user_un UNIQUE (email);


--
-- TOC entry 2985 (class 2606 OID 17604)
-- Name: application application_fk; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application
    ADD CONSTRAINT application_fk FOREIGN KEY (student_id) REFERENCES master_app."user"(id);


--
-- TOC entry 2986 (class 2606 OID 17609)
-- Name: application application_fk_1; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application
    ADD CONSTRAINT application_fk_1 FOREIGN KEY (master_id) REFERENCES master_app.master(id);


--
-- TOC entry 2987 (class 2606 OID 17614)
-- Name: application application_fk_2; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application
    ADD CONSTRAINT application_fk_2 FOREIGN KEY (referral1_id) REFERENCES master_app.referral(id);


--
-- TOC entry 2988 (class 2606 OID 17619)
-- Name: application application_fk_3; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application
    ADD CONSTRAINT application_fk_3 FOREIGN KEY (referral2_id) REFERENCES master_app.referral(id);


--
-- TOC entry 2991 (class 2606 OID 17576)
-- Name: application_ranking application_ranking_fk; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application_ranking
    ADD CONSTRAINT application_ranking_fk FOREIGN KEY (teacher_id) REFERENCES master_app."user"(id);


--
-- TOC entry 2992 (class 2606 OID 17581)
-- Name: application_ranking application_ranking_fk_1; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application_ranking
    ADD CONSTRAINT application_ranking_fk_1 FOREIGN KEY (application_id) REFERENCES master_app.application(id);


--
-- TOC entry 2993 (class 2606 OID 17594)
-- Name: application_review application_review_fk; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application_review
    ADD CONSTRAINT application_review_fk FOREIGN KEY (secretary_id) REFERENCES master_app."user"(id);


--
-- TOC entry 2994 (class 2606 OID 17599)
-- Name: application_review application_review_fk_1; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.application_review
    ADD CONSTRAINT application_review_fk_1 FOREIGN KEY (application_id) REFERENCES master_app.application(id);


--
-- TOC entry 2989 (class 2606 OID 17556)
-- Name: referral referral_fk; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.referral
    ADD CONSTRAINT referral_fk FOREIGN KEY (teacher_id) REFERENCES master_app."user"(id);


--
-- TOC entry 2990 (class 2606 OID 17561)
-- Name: referral referral_fk_1; Type: FK CONSTRAINT; Schema: master_app; Owner: postgres
--

ALTER TABLE ONLY master_app.referral
    ADD CONSTRAINT referral_fk_1 FOREIGN KEY (student_id) REFERENCES master_app."user"(id);


-- Completed on 2022-01-24 19:57:54

--
-- PostgreSQL database dump complete
--
