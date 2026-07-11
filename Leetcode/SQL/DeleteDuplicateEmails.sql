DELETE FROM Person p1
USING Person p2
WHERE p1.email = p2.email 
  AND p1.id > p2.id;


-- syntax error because the DISTINCT keyword must always be placed immediately after SELECT
-- SELECT ID, DISTINCT EMAIL FROM PERSON;