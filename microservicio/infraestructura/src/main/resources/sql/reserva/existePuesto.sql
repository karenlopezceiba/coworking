SELECT
      CASE WHEN EXISTS 
      (
            select * from sala where puestos_disponibles > 0
      )
      THEN 'TRUE'
      ELSE 'FALSE'
   END