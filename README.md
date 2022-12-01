# Thrift_Shop
Thrift-Shop Web requirement 
1. Introduction 

-This project is aimed at developing an online thrift shop system which supports for the product online or direct selling for the shop or anyone who wants to sell their old stuff. This system support for the below types of user 

• Guest: unregistered users 

• Customer: they are registered users who are actual customers or potential customers 

• Seller: the customer who can post the product for selling. 

• Admin: the organization leader/manager, acts as the system administrator 

2. Functional Requirements 

A. Overall Description 

The to-be-developed system includes the 4 features with the functions for each feature are listed in the beneath sections. It needs to provide 15 user screens with the flow as the following diagram. 

source: https://drive.google.com/file/d/1_T-e4Ly9kLPfeWRh-6W4VlyRdDVBl_RE/view?usp=sharing

B. Public Feature 

This feature includes the screens used for the Guests, as listed below
 - Home Page: the starting page of the system (about us) 
 - Products List: list of the active products
 - Product Details: details of the selected product 
 /*- Feedback: feedback generally or for a specific product */

C. Common Feature 
The common functions/screens used for all types of users, as listed below 
- User Login: authenticate the user to give him/her to access authorized features later on 
- User Register: register new user into the system, verified by the registered email 
- Reset Password: use in case the user forgot his/her password 
- Change Password: change user’s login password 
- User Profile: view & edit/update user profile 
- User Authorization: authorize user into the system functions based on his/her role 

D. Customer Feature 
This includes the screens used for system customers, as listed below 
- My Orders: for customer to view his/her submitted orders 
- Order Information: to show customer’s order details, the customer can edit or cancel the order when it is still in the submitted status 

E. Seller Feature 

This includes the screens used for sale persons, as listed below 
/* - Sales Dashboard: view general statistics & trends on the sale-related data */
- Orders List: list, filter, search, show, hide, view, add new or edit existing assigned order(s). 
- Shop Management : list, filter, search, show, hide, view, add new or edit existing assigned product(s).
- Add Product : create a new product for sell 

F. Admin Feature 

The Admin feature includes the screens used for the organization manager and system administrator, as listed below 
- Users List: list, filter, search, show, hide, view, add new or edit existing user(s) 
- User Details: view & edit the details of a specific user 

3. Other requirements
A. Configuring information
 - All the user-configured data (Post Categories, Product Categories, User Roles, Admin Menu, etc.) are defined and stored as the system setting(s). Those are managed via the Settings List & Setting Details as mentioned above 
 - Other once-configured data are managed via the system config files

 B. User Input data formats 
The types & format (length, validation, etc) of the input data are suggested by the project team and need to mentioned clearly in the analyzing & designing documents. 
- Those must be agreed by the supervisor (teacher) before implementing. 
- Once agreed, those must be implemented accordingly in the software input validating, data showing and in the system database
