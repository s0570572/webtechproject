create table entryEntity (
    EntryID     integer         not null,
    Title       varchar(30)     not null,
    Description varchar(250)    null,
    Topic       integer         not null,
    Difficulty  integer         not null,
    Link        varchar(100)    not null,
    constraint pk_entry primary key(EntryID),
    constraint fk_topic foreign key(Topic) references topicEntity,
    constraint fk_difficulty foreign key(Difficulty) references difficultyEntity
);

create table topicEntity (
    TopicID     integer         not null,
    Description varchar(15)     not null,
    constraint pk_topic primary key(TopicID)
);

create table difficultyEntity (
    DifficultyID    integer     not null,
    Description     varchar(8)  not null,
    constraint pk_difficulty primary key(DifficultyID)
);