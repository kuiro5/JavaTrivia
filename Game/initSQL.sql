/* create COURSES table */
create table question_bank
(
   question_number smallint not null,                     /* id, primary key                    */
   text varchar(500),                                 /* catalog number, e.g. 221           */
   answer_a varchar(100),                                /* course title                       */
   answer_b varchar(100),                                /* number of credits                  */
   answer_c varchar(100),                                 /* how many sections are offered now  */
   answer_d varchar(100),                                 /* who requires it? a service course? */
   correct_answer smallint,    
   difficulty smallint, 
   constraint pk_question_bank primary key (question_number)
);

/*create BUILDINGS table */
create table high_scores
(
    number smallint not null,                         /* id, the primary key             */
    name varchar(40),                                    /* full name of the building       */
    score smallint,                                   /* short name of the building  */    
    constraint pk_high_scores primary key (number)
);

/* add courses */
INSERT INTO QUESTIONS (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (1, 'What type of data member can only be accessed and modified within its class?', 'protected', 'public', 'private', 'int', 2, 1); 

INSERT INTO QUESTIONS (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (2, 'What keyword must be added to a clas in which a function is declared but not implemented?', 'abstract', 'public', 'void', 'extends', 0, 2);
INSERT INTO QUESTIONS (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (3, 'What is the name of the loop exclusive to Java that makes it easier to output data?', 'while loop', 'do while loop', 'for loop', 'enhanced for loop', 3, 3);

INSERT INTO QUESTIONS (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (4, 'What type of listener is mot commonly used for JButtons?', 'KeyListener', 'ItemListener', 'ActionListener', 'MouseListener', 2, 4);

/* add buildings */


/* add sections */
