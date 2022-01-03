package com.task.searchrepo.model

import com.squareup.moshi.Json

data class Repo(
    @field:Json(name = "id")
    var id: Int,

    @field:Json(name = "node_id")
    var nodeId: String,

    @field:Json(name = "name")
    var name: String,

    @field:Json(name = "full_name")
    var fullName: String,

    @field:Json(name = "private")
    var _private: Boolean,

    @field:Json(name = "owner")
    var owner: Owner,

    @field:Json(name = "html_url")
    var htmlUrl: String,

    @field:Json(name = "description")
    var description: String?,

    @field:Json(name = "fork")
    var fork: Boolean,

    @field:Json(name = "url")
    var url: String,

    @field:Json(name = "forks_url")
    var forksUrl: String,

    @field:Json(name = "keys_url")
    var keysUrl: String,

    @field:Json(name = "collaborators_url")
    var collaboratorsUrl: String,

    @field:Json(name = "teams_url")
    var teamsUrl: String,

    @field:Json(name = "hooks_url")
    var hooksUrl: String,

    @field:Json(name = "issue_events_url")
    var issueEventsUrl: String,

    @field:Json(name = "events_url")
    var eventsUrl: String,

    @field:Json(name = "assignees_url")
    var assigneesUrl: String,

    @field:Json(name = "branches_url")
    var branchesUrl: String,

    @field:Json(name = "tags_url")
    var tagsUrl: String,

    @field:Json(name = "blobs_url")
    var blobsUrl: String,

    @field:Json(name = "git_tags_url")
    var gitTagsUrl: String,

    @field:Json(name = "git_refs_url")
    var gitRefsUrl: String,

    @field:Json(name = "trees_url")
    var treesUrl: String,

    @field:Json(name = "statuses_url")
    var statusesUrl: String,

    @field:Json(name = "languages_url")
    var languagesUrl: String,

    @field:Json(name = "stargazers_url")
    var stargazersUrl: String,

    @field:Json(name = "contributors_url")
    var contributorsUrl: String,

    @field:Json(name = "subscribers_url")
    var subscribersUrl: String,

    @field:Json(name = "subscription_url")
    var subscriptionUrl: String,

    @field:Json(name = "commits_url")
    var commitsUrl: String,

    @field:Json(name = "git_commits_url")
    var gitCommitsUrl: String,

    @field:Json(name = "comments_url")
    var commentsUrl: String,

    @field:Json(name = "issue_comment_url")
    var issueCommentUrl: String,

    @field:Json(name = "contents_url")
    var contentsUrl: String,

    @field:Json(name = "compare_url")
    var compareUrl: String,

    @field:Json(name = "merges_url")
    var mergesUrl: String,

    @field:Json(name = "archive_url")
    var archiveUrl: String,

    @field:Json(name = "downloads_url")
    var downloadsUrl: String,

    @field:Json(name = "issues_url")
    var issuesUrl: String,

    @field:Json(name = "pulls_url")
    var pullsUrl: String,

    @field:Json(name = "milestones_url")
    var milestonesUrl: String,

    @field:Json(name = "notifications_url")
    var notificationsUrl: String,

    @field:Json(name = "labels_url")
    var labelsUrl: String,

    @field:Json(name = "releases_url")
    var releasesUrl: String,

    @field:Json(name = "deployments_url")
    var deploymentsUrl: String,

    @field:Json(name = "created_at")
    var createdAt: String?,

    @field:Json(name = "updated_at")
    var updatedAt: String?,

    @field:Json(name = "pushed_at")
    var pushedAt: String?,

    @field:Json(name = "git_url")
    var gitUrl: String,

    @field:Json(name = "ssh_url")
    var sshUrl: String,

    @field:Json(name = "clone_url")
    var cloneUrl: String,

    @field:Json(name = "svn_url")
    var svnUrl: String,

    @field:Json(name = "homepage")
    var homepage: String?,

    @field:Json(name = "size")
    var size: Int,

    @field:Json(name = "stargazers_count")
    var stargazersCount: Int,

    @field:Json(name = "watchers_count")
    var watchersCount: Int,

    @field:Json(name = "language")
    var language: String?,

    @field:Json(name = "has_issues")
    var hasIssues: Boolean,

    @field:Json(name = "has_projects")
    var hasProjects: Boolean,

    @field:Json(name = "has_downloads")
    var hasDownloads: Boolean,

    @field:Json(name = "has_wiki")
    var hasWiki: Boolean,

    @field:Json(name = "has_pages")
    var hasPages: Boolean,

    @field:Json(name = "forks_count")
    var forksCount: Int,

    @field:Json(name = "mirror_url")
    var mirrorUrl: Any?,

    @field:Json(name = "archived")
    var archived: Boolean,

    @field:Json(name = "disabled")
    var disabled: Boolean,

    @field:Json(name = "open_issues_count")
    var openIssuesCount: Int,

    @field:Json(name = "license")
    var license: License?,

    @field:Json(name = "allow_forking")
    var allowForking: Boolean,

    @field:Json(name = "is_template")
    var isTemplate: Boolean,

    @field:Json(name = "topics")
    var topics: List<String>?,

    @field:Json(name = "visibility")
    var visibility: String,

    @field:Json(name = "forks")
    var forks: Int,

    @field:Json(name = "open_issues")
    var openIssues: Int,

    @field:Json(name = "watchers")
    var watchers: Int,

    @field:Json(name = "default_branch")
    var defaultBranch: String,

    @field:Json(name = "score")
    var score: Float
)
