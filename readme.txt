Below assumptions are made:

1. One subcategory can only belong to One and only One Category

2. The Inventory quantity must be integer number

3. One Category can have more than one subcategory

4. The inventory once created cannot change its category

5. Category cannot be changed or updated, so do the subcategory

6.

Rest Api
1. Get http://localhost:8080/inventories to get all the inventories records

2. GET http://localhost:8080/inventories/name/{name} to query the inventories by name

3. POST http://localhost:8080/inventories with the request body to create new record

4. PUT http://localhost:8080/inventories with the request body to update existing record

5. GET http://localhost:8080/inventories/page/{pageNo}?size=2 for paging result
=================================================

Remarks
the following command really work to get the check sum of all files :)

find . | xargs cksum