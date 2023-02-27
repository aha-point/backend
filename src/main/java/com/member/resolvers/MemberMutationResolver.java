package com.member.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.member.interfaces.mutation.MemberMutation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class MemberMutationResolver implements GraphQLMutationResolver {

    private MemberMutation memberMutation;
}
