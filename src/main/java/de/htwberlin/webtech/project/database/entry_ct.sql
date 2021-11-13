create table entry (
    EntryID     integer         not null,
    Title       varchar(30)     not null,
    Description varchar(250)    null,
    Topic       varchar(15)     not null,
    Difficulty  varchar(8)      not null,
    Link        varchar(100)    not null,
    constraint pk_entry primary key(EntryID)
);