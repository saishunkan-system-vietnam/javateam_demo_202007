CREATE TABLE public."user" (
	"id serial"		NOT 		NULL,
	"name"			varchar 	NULL,
	"email" 		varchar 	NULL,
	"password" 		varchar 	NULL,
	"created_date"	timestamp	NULL	DEFAULT CURRENT_TIMESTAMP,
	"created_user"	varchar 	NULL,
	"updated_date"	timestamp	NULL	DEFAULT CURRENT_TIMESTAMP,
	"updated_user"	varchar 	NULL,
	CONSTRAINT account_role_pkey PRIMARY KEY (id)
);