package com.member.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.member.interfaces.query.MemberQuery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class MemberQueryResolver implements GraphQLQueryResolver {

    private MemberQuery memberQuery;
}
