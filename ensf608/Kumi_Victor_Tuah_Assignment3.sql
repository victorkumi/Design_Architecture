

#Query 1
SELECT C.Fname, C.Lname, T.StudioName FROM COMPETITOR AS C, TEACHER As T Where C.TeacherId =  T.TeacherId;

#Query 2
SELECT T.StudioName, count(C.CompetitorId) FROM COMPETITOR AS C INNER JOIN  TEACHER AS T ON C.TeacherId = T.TeacherId GROUP BY T.StudioName;

#Query 3
SELECT T.StudioName, count(T.TeacherId) FROM TEACHER AS T GROUP BY T.StudioName ;

#Query 4
SELECT T.Lname FROM TEACHER AS T, COMPETITOR AS C WHERE C.TeacherId = T.TeacherId GROUP BY T.Lname HAVING COUNT(C.TeacherId) > 1;

#Query 5
 SELECT C.Lname, C.Fname, Comp.Title From COMPETITOR AS C 
INNER JOIN PERFORMANCE AS P ON C.CompetitorId = P.CompetitorId
INNER JOIN COMPOSITION AS Comp ON Comp.MusicId = P.MusicId WHERE Comp.Genre = "Romantic";


#Query 6
SELECT Comp.Title, P.CategoryId  FROM COMPOSITION AS Comp
LEFT OUTER JOIN PERFORMANCE AS P  ON P.MusicId = Comp.MusicId;




#Query 7
CREATE VIEW SCORE_ANALYSIS AS SELECT C.Age, P.Score FROM COMPETITOR AS C, PERFORMANCE AS P WHERE C.CompetitorId = P.CompetitorId;
SELECT * FROM SCORE_ANALYSIS;

#Query 8
SELECT * FROM SCORE_ANALYSIS ORDER BY Score DESC;

#Query 9
SELECT max(Score), min(Score), AVG(Score) FROM SCORE_ANALYSIS;

#Query 10
ALTER TABLE COMPOSITION
ADD Copyright VARCHAR(10) NOT NULL DEFAULT "SOCAN" AFTER Genre ;
SELECT * FROM COMPOSITION;

#Query 11
SELECT Comp.CompetitorId FROM COMPETITOR AS Comp  WHERE NOT EXISTS(SELECT MinAge FROM  CATEGORY AS Cat WHERE Comp.Age >= Cat.MinAge AND Comp.Age <= Cat.MaxAge);


#Query 12
ALTER TABLE COMPETITOR ADD CONSTRAINT AgeConstraint CHECK (Age >= 5 AND Age <= 18);


#Query 13
UPDATE STUDIO SET Name ="Harmony Studio" WHERE Name = 'Harmony Inc.';
SELECT * FROM STUDIO;
SELECT * FROM TEACHER;
# The update is reflected in, TEACHER and STUDIO,  because there is a cascade trigger on update of STUDIO.


#Question 14
# COMPOSITION and PERFORMANCE tables would be affected. 
# COMPOSITION because that is where Beethoven is removed. And PERFORMANCE because it references the COMPOSITION table through 
# music id; cascading effect in this case

#Question 15
#So we are effectively creating a trigger named 'Certification' with the message in the 'MESSAGE_TEXT variable before an update is made on any row of the TEACHER table.
#The 'SIGNAL' statement is the reason why the table wouldn't be updated because it causes an error in this case a generic sqlstate of 45000 which is
#an unhandled user defined exception.



