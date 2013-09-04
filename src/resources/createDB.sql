/* create question_bank table */
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

/*create high_scores table */
create table high_scores
(
    player_number smallint not null,                         /* id, the primary key             */
    player_name varchar(40),                                    /* full name of the building       */
    player_score smallint,                                   /* short name of the building  */    
    constraint pk_high_scores primary key (player_number)
);

/* add questions */
INSERT INTO QUESTION_BANK (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (1, 'What type of data member can only be accessed and modified within its class?', 'protected', 'public', 'private', 'int', 2, 1); 

INSERT INTO QUESTION_BANK (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (2, 'In Java, what keyword must be added to a class in which a function is declared but not implemented?', 'abstract', 'public', 'void', 'extends', 0, 2);

INSERT INTO QUESTION_BANK (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (3, 'What is the name of the loop exclusive to Java?', 'while loop', 'do while loop', 'for loop', 'enhanced for loop', 3, 3);

INSERT INTO QUESTION_BANK (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (4, 'In Java, what type of listener is most commonly used for JButtons?', 'KeyListener', 'ItemListener', 'ActionListener', 'MouseListener', 2, 4);

INSERT INTO QUESTION_BANK (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (5, 'In Java, which of these is refered to the wildcard character', '_', '*', '^', '@', 1, 5);

INSERT INTO QUESTION_BANK (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (6, 'What was the original name for the Java programming language', 'Tea', 'Unity', 'D++', 'Oak', 3, 6);

INSERT INTO QUESTION_BANK (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (7, 'Which of the following is not part of the Reduced Instruction Set Computing (RISC) design', 'Smaller is faster', 'Simplicity favors regularity', 'Larger is nessesary', 'Make the common case fast', 2, 7);

INSERT INTO QUESTION_BANK (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (8, 'In what year did the programming language C++ first appear', '1972', '1983', '1994', '1964', 1, 7);

INSERT INTO QUESTION_BANK (QUESTION_NUMBER, TEXT, ANSWER_A, ANSWER_B, ANSWER_C, ANSWER_D, CORRECT_ANSWER, DIFFICULTY) 
VALUES (9, 'Who is the primary creator of the Java programming language', 'James Gosling', 'Bill Gates', 'Bill Joy', 'Scott McNealy', 0, 9);

/* add highscores */
INSERT INTO HIGH_SCORES (PLAYER_NUMBER, PLAYER_NAME, PLAYER_SCORE) 
VALUES (0, 'John', 0);
